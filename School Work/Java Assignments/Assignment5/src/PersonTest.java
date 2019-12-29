
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class PersonTest 
{
    public static void main(String[] args)
    {
        
        System.out.println("Creating executor pool");
        //creates exectuor object
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //creating 4 different threads for pool
        executor.execute(new Person("John", "Smith"));
        executor.execute(new Person("John", "Smith"));
        executor.execute(new Person("John", "Smith"));
        executor.execute(new Person("John", "Smith"));
        
       
            //logic to display message when all theads have executed, and executor has shutdown
            executor.shutdown();
            while(!executor.isTerminated())
            {
                if(executor.isTerminated())
            {
                System.out.println("Thread pool has finished");
                break;
            }
            }
            
        
        
        
        
    }
    
    
    
    
}
