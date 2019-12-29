import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PaymentFrame extends JFrame
{
    public PaymentFrame()
    {
        //setting layout
        setLayout(new GridLayout(6, 2, 5, 5));

        //labels and fields
        JLabel name = new JLabel("Name and Surname: ");
        JTextField namefield = new JTextField();

        JLabel address = new JLabel("Address: ");
        JTextField addressfield = new JTextField();

        JLabel ccnum = new JLabel("Credit Card Number: ");
        JTextField ccnumfield = new JTextField();

        JLabel exp = new JLabel("Expiration Date: ");
        JTextField expfield = new JTextField();

        JLabel cvc = new JLabel("CVC: ");
        JTextField cvcfield = new JTextField();

        //pay button and listener
        JButton pay = new JButton("Pay");
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(pay, "Your order will be delivered in 30 minutes", "Message", JOptionPane.OK_OPTION);
                System.exit(0);

            }
        });

        add(name);
        add(namefield);
        add(address);
        add(addressfield);
        add(ccnum);
        add(ccnumfield);
        add(exp);
        add(expfield);
        add(cvc);
        add(cvcfield);
        add(pay);

    }

}
