import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ConvertFrame extends JFrame
{
    //variables for conversion
String fahrenheit;
float number1 = (5/9);
double CResult;
String inches;


    public ConvertFrame()
    {
        setLayout(new FlowLayout());
        //creating labels
        JLabel FLabel = new JLabel("Enter Fahrenheit Temperature: ");
        add(FLabel);
        //creating textfield
        JTextField FTField = new JTextField(5);
        //creatinv conversion button
        JButton FtoCConvert = new JButton("Convert");
        FtoCConvert.setSize(200,200);
        //creating ending label
        JLabel fToCResult = new JLabel("Fahrenheit to Celcius is: ");
        //action listener that will convert when button is pressed
        FtoCConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fahrenheit = FTField.getText();
                float tempC = StringtoInt(fahrenheit);

                double CResult = ((tempC - 32) / (1.8));
                int CResultInt = (int) CResult;

                fToCResult.setText("Fahrenheit to Celcius is: " +CResultInt);
            }
        });
        //conversion actionlistener for enter press on text field
        FTField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fahrenheit = FTField.getText();
                float tempC = StringtoInt(fahrenheit);

                double CResult = ((tempC - 32) / (1.8));
                int CResultInt = (int) CResult;

                fToCResult.setText("Fahrenheit to Celcius is: " +CResultInt);

            }
        });
        //adding rest
        add(FTField);
        add(FtoCConvert);
        add(fToCResult);


        //inches conversion start

        //adding first label
        JLabel Inches = new JLabel("Enter inch length: ");
        add(Inches);
        //adding text field
        JTextField InchTextField = new JTextField(5);
        //adding button
        JButton InchConvert = new JButton("Convert");
        InchConvert.setSize(200,200);
        //adding conversion label
        JLabel ItoCConvert = new JLabel("Inch to Centimeter is: ");
        //button conversion actionlistener
        InchConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inches = InchTextField.getText();
                float tempI = StringtoInt(inches);

                double CResult = (tempI * 2.54);
                int CentiFinal = (int) CResult;

                ItoCConvert.setText("Inches to centimeters is : " +CentiFinal);
            }
        });
        //textfield enter press actionlistener conversion
        InchTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inches = InchTextField.getText();
                float tempI = StringtoInt(inches);

                double CResult = (tempI * 2.54);
                int CentiFinal = (int) CResult;

                ItoCConvert.setText("Inches to centimeters is : " +CentiFinal);

            }
        });
        //adding rest
        add(InchTextField);
        add(InchConvert);
        add(ItoCConvert);
    }
    //parsing method
    public int StringtoInt(String x)
    {
        return Integer.parseInt(x);
    }
    //formula for converting fahrenheit to celcius
    public int FtoC(int x)
    {
        return ((x-32)*(5/9));
    }

}
