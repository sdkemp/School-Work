
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountSavings
{
    //instance variables
    public static double annualRate = 5.3;
    public static double savings = 100;

    //method to calculate montly interest
    public static double calcInterest(double rate, double saving)
    {
        double total = 0;
        //calcs the monthly rate
        double monthlyRate = (rate/12);
        //turns percentage into deicmals
        double x = (monthlyRate/100);
        //calcs interest from savings amount
        total = (saving*x);
        

        return total;
    }

    public static void main(String[] args)
    {
        //runs both threads thru method
        running();
    }
    //method for running both threads
    public static void running()
    {
        //first thread
        Runnable t1 = new Runnable() {
            @Override
            public void run() 
            {
                double totalSavings = savings;
                //calcs interest 12 times, then adds that interest to the savings 
                for(int x = 0; x < 11; x++)
                {
                    totalSavings += calcInterest(annualRate, totalSavings);
                }
                System.out.println("First thread has finished. Savings is now: " +(savings+totalSavings));
                
                //first thread then sleeps for 5 seconds
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AccountSavings.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        //second thread, using same methods as t1
        Runnable t2 = new Runnable() {
            @Override
            public void run() 
            {
              double totalSavings = savings;
                //calcs interest 12 times, then adds that interest to the savings 
                for(int x = 0; x < 11; x++)
                {
                    totalSavings += calcInterest(annualRate, totalSavings);
                }
                System.out.println("Second thread has finished. Savings is now: " +(savings+totalSavings));
            
           
            }
        };
        //runs the threads
        t1.run();
        t2.run();
        
    }
}

