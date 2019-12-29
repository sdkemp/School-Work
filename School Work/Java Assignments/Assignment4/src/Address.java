/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel
 */
public class Address 
{
    //getters and setters for all parameters
    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getAddressFN() {
        return addressFN;
    }

    public void setAddressFN(String addressFN) {
        this.addressFN = addressFN;
    }

    public String getAddressLN() {
        return addressLN;
    }

    public void setAddressLN(String addressLN) {
        this.addressLN = addressLN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //Variables for address
    int addressID;
    String addressFN;
    String addressLN;
    String email;
    String phone;
    
    //default constructor
    public Address(int addressID, String addressFN, String addressLN, String email, String phone)
    {
        this.addressID = addressID;
        this.addressFN = addressFN;
        this.addressLN = addressLN;
        this.email = email;
        this.phone = phone;
        
        
    }
    
    
}
