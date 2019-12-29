import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import java.net.URL;
import javax.swing.*;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class MyMenuFrame extends JFrame
{
    //declaring these for global boolean checks
    JCheckBoxMenuItem bold;
    JCheckBoxMenuItem italic;
  
    int currentFont = 0;
    //text area
    JTextArea text = new JTextArea();
    //homepage url viewer
    public static void openWebpage (String urlString) 
    {try {Desktop.getDesktop().browse(new    URL(urlString).toURI());} catch (Exception e) {e.printStackTrace();}}
    public MyMenuFrame()
    {
        
        
        JMenuBar menuBar = new JMenuBar();
        
        //setting menus and mnemonics
        JMenu file = new JMenu("File");
        file.setMnemonic('F');
        JMenu edit = new JMenu("Edit");
        edit.setMnemonic('D');
        JMenu print = new JMenu("Print");
        print.setMnemonic('P');
        JMenu help = new JMenu("Help");
        help.setMnemonic('H');
        
        //file menu bar
        menuBar.add(file);
        //adding menuitems for File
        
        //open menu item
        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke('O', CTRL_DOWN_MASK));
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JFileChooser filechooser = new JFileChooser();
                filechooser.showOpenDialog(rootPane);
            }
        });
        
        //save menu item
        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 JFileChooser filechooser = new JFileChooser();
                filechooser.showSaveDialog(rootPane);
            }
        });
        
        //exit menu item
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke('X', CTRL_DOWN_MASK));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(WIDTH);
            }
        });
        file.add(open);
        file.add(save);
        file.add(exit);
        
        //edit menu bar
        menuBar.add(edit);
        JMenu color = new JMenu("Color");
        JMenuItem changeColor = new JMenuItem("Change Color");
        changeColor.setAccelerator(KeyStroke.getKeyStroke('C', CTRL_DOWN_MASK));
        color.add(changeColor);
        changeColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
                Color color = JColorChooser.showDialog(rootPane, "Please choose a color for your text", Color.red);
                text.setForeground(color);
                
                
            }
        });
        
        //font menu bar
        JMenu font = new JMenu("Font");
        ButtonGroup fontGroup = new ButtonGroup();
        //times new roman
        JRadioButtonMenuItem tnr = new JRadioButtonMenuItem("Times New Roman");
        tnr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(bold.isSelected() && italic.isSelected() == false)
                {
                    Font tr = new Font("Times New Roman", Font.BOLD, 20);
                    text.setFont(tr);
                    currentFont = 1;
                }
                else if(bold.isSelected() && italic.isSelected())
                {
                    Font tr = new Font("Times New Roman", (Font.BOLD + Font.ITALIC), 20);
                    text.setFont(tr);
                    currentFont = 1;
                }
                else if (italic.isSelected() && bold.isSelected() == false)
                {
                    Font tr = new Font("Times New Roman", Font.ITALIC, 20);
                    text.setFont(tr);
                    currentFont = 1;
                }
                else 
                {
                    
                      Font tr = new Font("Times New Roman", Font.PLAIN, 20);
                      text.setFont(tr);
                      currentFont = 1;
                }
             
            }
        });
        fontGroup.add(tnr);
        font.add(tnr);
        //Arial
        JRadioButtonMenuItem arial = new JRadioButtonMenuItem("Arial");
        arial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               if(bold.isSelected() && italic.isSelected() == false)
               {
                    Font arial = new Font("Arial", Font.BOLD, 20);
                    text.setFont(arial);
                   
               }
               else if(bold.isSelected() && italic.isSelected())
               {
                    Font arial = new Font("Arial", (Font.BOLD + Font.ITALIC), 20);
                    text.setFont(arial);
                    currentFont = 1;
               }
               else if (italic.isSelected() && bold.isSelected() == false)
               {
                    Font arial = new Font("Arial", Font.ITALIC, 20);
                    text.setFont(arial);
                    currentFont = 1;
               }
               else 
               {
                    
                      Font arial = new Font("Arial", Font.PLAIN, 20);
                      text.setFont(arial);
                      currentFont = 1;
               }
                
            }
        });
        fontGroup.add(arial);
        font.add(arial);
        //Serif
        JRadioButtonMenuItem serif = new JRadioButtonMenuItem("Serif");
        serif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(bold.isSelected() && italic.isSelected() == false)
                {
                    Font Serif = new Font("Serif", Font.BOLD, 20);
                    text.setFont(Serif);
                   
                }
                else if(bold.isSelected() && italic.isSelected())
                {
                    Font Serif = new Font("Serif", (Font.BOLD + Font.ITALIC), 20);
                    text.setFont(Serif);
                    
                }
                else if (italic.isSelected() && bold.isSelected() == false)
                {
                    Font Serif = new Font("Serif", Font.ITALIC, 20);
                    text.setFont(Serif);
                  
                }
                else 
                {
                    
                      Font Serif = new Font("Serif", Font.PLAIN, 20);
                      text.setFont(Serif);
                      
                }
            }
        });
        fontGroup.add(serif);
        font.add(serif);
        
        font.addSeparator();
        
        
        //Bold
        bold = new JCheckBoxMenuItem("Bold");
        
        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               if(bold.isSelected() && italic.isSelected() == false)
               {
                   
                   text.setFont(text.getFont().deriveFont(Font.BOLD));
               }
               if(bold.isSelected() && italic.isSelected() == true)
               {
                   text.setFont(text.getFont().deriveFont((Font.ITALIC+Font.BOLD)));
               }
               if(bold.isSelected() == false && italic.isSelected() == true)
               {
                   text.setFont(text.getFont().deriveFont(Font.ITALIC));
               }
               if(bold.isSelected() == false && italic.isSelected() == false)
               {
                  text.setFont(text.getFont().deriveFont(Font.PLAIN));
               }
            }
        });
        
        font.add(bold);
        //Italic
        italic = new JCheckBoxMenuItem("Italic");
        italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               if(italic.isSelected() && bold.isSelected() == false)
               {
                   
                   text.setFont(text.getFont().deriveFont(Font.ITALIC));
               }
               if(italic.isSelected() && bold.isSelected() == true)
               {
                   text.setFont(text.getFont().deriveFont(Font.ITALIC+Font.BOLD));
               }
               if(italic.isSelected() == false && bold.isSelected() == true)
               {
                   text.setFont(text.getFont().deriveFont(Font.BOLD));
               }
               if(italic.isSelected() == false && bold.isSelected() == false)
               {
                  text.setFont(text.getFont().deriveFont(Font.PLAIN));
               }
            }
        });
       
        font.add(italic);
        
        
        edit.add(color);
        edit.add(font);
        
        //print menu bar
        menuBar.add(print);
        JMenuItem sendToPrint = new JMenuItem("Send to Print");
        sendToPrint.setAccelerator(KeyStroke.getKeyStroke('P', CTRL_DOWN_MASK));
        sendToPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
              int x = JOptionPane.showConfirmDialog(rootPane, "Do you want to print this file?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
              if( x == 0 )
              {
                  JOptionPane.showMessageDialog(rootPane, "The file has been successfully printed", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
              }
            }
        });
        print.add(sendToPrint);
        
        //help menu bar
        menuBar.add(help);
        
        
        //about menu item
        JMenuItem about = new JMenuItem("About");
        about.setAccelerator(KeyStroke.getKeyStroke('A', CTRL_DOWN_MASK));
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(rootPane, "This software was made in 2019 \n Version 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
                
            }
        });
                
        //Homepage menu item
        JMenuItem home = new JMenuItem("Visit Homepage");
        home.setAccelerator(KeyStroke.getKeyStroke('V', CTRL_DOWN_MASK));
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                MyMenuFrame.openWebpage("http://www.microsoft.com");
            }
        });
        help.add(about);
        help.add(home);
        
        setJMenuBar(menuBar);
        
        
        
        
        add(text);
        
    }
    
    
    
    
}
