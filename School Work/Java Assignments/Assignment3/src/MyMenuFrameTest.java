
import javax.swing.JFrame;


public class MyMenuFrameTest 
{
    public static void main(String[] args)
       {
           MyMenuFrame frame = new MyMenuFrame();
           frame.setTitle("MyNotePad");

           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           frame.setSize(600, 400);
           frame.setVisible(true);
       }   
}
