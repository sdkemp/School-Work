
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel
 */
public class Server extends JFrame
{
    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket connection;
    private ServerSocket server;
    private int counter = 1;
    
    public Server()
    {
        super("Server");
        enterField = new JTextField();
        enterField.setEditable(false);
        
        new ActonListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                sendData(event.getActionCommand());
                enterField.setText("");
            }
        };
        
        add(enterField, BorderLayout.NORTH);
        displayArea = new JTextArea ();
        add(new JScrollPane (displayArea), BorderLayout.CENTER);
        this.setVisible(true);
        setSize(300, 300);
        
    }
    
    public void runServer()
    {
        
        try {
            server = new ServerSocket(12345, 100);
            
            while(true)
            {
                try {
                waitForConnection();
                getStreams();
                processConnection();
                
                }
                catch(EOFException e)
                {
                    displayMessage("Server terminated connection");
                }
                finally
                {
                  closeConnection();
                  ++counter;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void waitForConnection() throws IOException
    {
        displayMessage("Waiting for connection");
        connection = server.accept();
        displayMessage("Connection " +counter + " received from: "+connection.getInetAddress().getHostName());
        
        
    }
    
    private void getStreams() throws IOException
    {
        output = new ObjectOutputStream (connection.getOutputStream());
        output.flush();
        
        input = new ObjectInputStream(connection.getInputStream());
        displayMessage("Got I/O stremas");
        
    }
    
    private void processConnection() throws IOException
    {
        String message = "Connection successfull";
        sendData(message);
        setTextFieldEditable(true);
        
        do {
            try {
                message = (String) input.readObject();
                displayMessage("\n"+message);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }while(message.equals("Client >>> TERMINATE"));
        
    }
    
    private void closeConnection()
    {
        displayMessage("Terminating connection");
        setTextFieldEditable(false);
        try {
            
            
            output.close();
            input.close();
            connection.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    private void sendData (String message)
    {
        try {
            output.writeObject("SERVER>>> "+message);
            output.flush();
            displayMessage("\nSERVER>>> "+message);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void displayMessage(final String messageToDisplay)
    {
        SwingUtilities.invokeLater (
        
                new Runnable()
                {
                    public void run ()
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
        
       
        
    }
    
    private void setTextFieldEditable (final boolean editable)
    {
        SwingUtilities.invokeLater(
        
                new Runnable()
                {
                    public void run()
                    {
                        enterField.setEditable(editable);
                    }
                    
                    
                }
        
        
        
        
        
        
        
        );
        
        
    }
    
    
}
