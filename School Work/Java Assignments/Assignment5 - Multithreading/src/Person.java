import java.lang.Runnable;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Person implements Runnable
{
    //names
    public static String fName;
    public static String lName;
    //constructor
    public Person(String first, String last)
    {
        fName = first;
        lName = last;
    }
    //methods to create threads
    @Override
    public void run()
    {
        
        System.out.println(fName +" "+lName+" has begun working");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         System.out.println(fName +" "+lName+" has finished working");
       
        
    }
    
    
}
