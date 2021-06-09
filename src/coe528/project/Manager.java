package coe528.project;
import java.io.*;
import java.util.*;
/**
 *
 * @author dimac
 */
public class Manager extends User {
    
    public Manager()
    {
        Username = "admin";
        Password = "admin";
        Role = "Manager";
    }
    
    public void AddCustomer(String Username, String Password)
    {
        File file = new File("C:\\Users\\dimac\\Desktop\\JavaFX\\JavaFXApplication\\"  + Username +".txt" );
        if(file.exists())
        {
            System.out.println("Already Exits");
        }
        else
        {
            CFile cfile = new CFile();
            cfile.WriteFile(new Customer(Username, Password));
        }
    }
    public void DeleteCustomer(String Username)
    {
        File file = new File("C:\\Users\\dimac\\Desktop\\JavaFX\\JavaFXApplication\\"  + Username +".txt"  );
        if(file.exists())
        {
            System.out.println("Exits");
            file.delete();
        }
        else
        {
            System.out.println("File Doesnt Exit");
        }
    }
    
    @Override
    public String toString()
    {
        return "" + Username + " - " + Password + "";
    }
    
}
