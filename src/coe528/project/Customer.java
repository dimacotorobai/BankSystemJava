package coe528.project;

/**
 *
 * @author dimac
 */
public class Customer extends User{
    
    // Overview: Customer is immutable as all elements are final and cannot be change once instanciated.
    //
    // The abstraction function is:
    // a)Write the abstraction function here
    //
    // AF(c) c.account is an Object of the account type. This object has many other instance variables which can be accessed like
    //c.account.money, c.account.szStatus. Each customer has a unique username.
    // 
    //
    //
    // The rep invariant is:
    // b)Write the rep invariant here
    // c.account is of the type account and cannot be null pointer.
    // 
    // 
    //
    //the rep
    BankAccount account;
    
    Customer(String Username, String Password)
    {
        //REQUIRES: two non null strings named Username, and Password
        //MODIFIES: does not modify this.Username, this.Password, Role;
        // EFFECTS: instanciates Username, Password, Role, and account
        this.Username = Username;
        this.Password = Password;
        Role = "Customer";
        account = new BankAccount();
    }
    
    /**
     *
     * @return
     */
    public boolean repOK()
    {
        //REQUIRES: two non null strings named Username, Password, account
        //MODIFIES: does not modify any elements of the class
        // EFFECTS: returns true if all elements are not null, otherwise it returns false;
        if(Username == null){
            return false;
        }
        if(Password == null)
        {
            return false;
        }
        if(account == null)
        {
            return false;
        }
        
        return true;
    }
    
    
    public String toString()
    {
        //REQUIRES: two non empty and non null strings.
        //MODIFIES: does not modify any variable
        // EFFECTS: Returns the a string with contains both the username and password
        return "" + Username + " - " + Password + "";
    }
     
}
