

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddressOptions 
{
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pstatement = null;
    
    //constructor that connects to the database
    public AddressOptions()
    {
        
        try {
            connection = DriverManager.getConnection(Database.DATABASE_URL, Database.USERNAME, Database.PASSWORD);
            System.out.println("CONNECTED");
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method that will pull all of the entires in Addresses table
    public ArrayList<Address> viewAddresses()
    {
        try 
        {
            //selects all from Addresses and then puts results into an arraylist
            ArrayList<Address> address = new ArrayList<Address>();
            statement = connection.createStatement();
            String query = "select * from ADDRESSES";
            ResultSet results = statement.executeQuery(query);
            
            while(results.next())
            {
                
                int id = results.getInt("AddressID");
                String fn = results.getString("FirstName");
                String ln = results.getString("LastName");
                String email = results.getString("Email");
                String phone = results.getString("PhoneNumber");
                
                address.add(new Address(id, fn, ln, email, phone));
            }
            
            
            return address;
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    //adds an address to table using parameters
    public void addAddress( String fn, String ln, String email, String phone)
    {
        
        try {
            String query ="insert into Addresses (FIRSTNAME, LASTNAME, EMAIL, PHONENUMBER) values (?,?,?,?)";
            
            pstatement = connection.prepareStatement(query);
            
            pstatement.setString(1, fn);
            pstatement.setString(2, ln);
            pstatement.setString(3, email);
            pstatement.setString(4, phone);
            pstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    //updates the address that is selected with ID
    public void updateAddress(int id, String fn, String ln, String email, String phone)
    {
        try {
            String query;
            
            query = "update ADDRESSES set FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PHONENUMBER= ? where ADDRESSID = ?";
            
            pstatement = connection.prepareStatement(query);
            
            pstatement.setString(1, fn);
            pstatement.setString(2, ln);
            pstatement.setString(3, email);
            pstatement.setString(4, phone);
            pstatement.setInt(5, id);
            pstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //deletes the address with the given id
    public void deleteAddress(int id)
    {
        try {
            String query;
            query = "delete from Addresses where AddressID = ?";
            
            pstatement = connection.prepareStatement(query);
            pstatement.setInt(1, id);
            pstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //will delete all entires from teh Addresses table
    public void deleteAll()
    {
        
        try {
            String query;
            query = "delete from Addresses";
            pstatement = connection.prepareStatement(query);
            pstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
