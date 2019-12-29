
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel
 */
public class Client extends JFrame
{
    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message="";
    private String chatServer;
    private Socket client;
    
    public Client(String host)
    {
        super("Client");
        
        chatServer = host;
        
        enterField = new JTextField("");
        setEditableText(false);
        
        enterField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                sendData(e.getActionCommand());
                enterField.setText("");
            }
        });
        
        add(enterField, BorderLayout.NORTH);
        displayArea = new JTextArea();
        add(new JScrollPane (displayArea), BorderLayout.CENTER);
        setSize(300, 150);
        setVisible(true);
    }
    
    public void runClient()
    {
        try {
            
            connectToServer();
            getStream();
            processConnection();
        } 
        catch(EOFException e)
        {
            displayMessage("Client Terminated Connection");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        finally {
            closeConnection();
        }
    }
    
    private void connectToServer () throws IOException {
        
        displayMessage("Attempting to connect");
        client = new Socket(InetAddress.getByName(chatServer), 12345);
        displayMessage("Connect to: "+client.getInetAddress().getHostName());
        
        
    }
    
    private void getStream () throws IOException
    {
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        
        input = new ObjectInputStream(client.getInputStream());
        displayMessage("\nGet IO Streams \n");
    }
    
    
    private void processConnection () throws IOException
    {
        setEditableText(true);
        
        do {
            try{
                message = (String ) input.readObject();
                displayMessage("\n"+ message);
            }
            catch(ClassNotFoundException ex)
            {
                
            }
                    
            
            
        }while(!message.equals("SERVER >>> TERMINATE"));
        
    
        
    }
    private void closeConnection()
    {
        try {
            displayMessage("\n Closing connection");
            setEditableText(false);
            
            output.close();
            input.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
    }
    
    private void sendData(String message)
    {
        try {
            output.writeObject("Client>>> "+message);
            output.flush();
            displayMessage("\nClient>>> "+message);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    private void displayMessage (final String messageToDisplay)
    {
        SwingUtilities.invokeLater(
        
        new Runnable()
        {
            public void run()
            {
                displayArea.append(messageToDisplay);
            }
        }
        
        
        
        );
    }
    
    private void setEditableText(final boolean edit)
    {
        SwingUtilities.invokeLater(
        
        new Runnable()
        {
            public void run()
            {
                enterField.setEditable(edit);
            }
        }
        
        
        );
    }
    
    
    
    
    
    
}
