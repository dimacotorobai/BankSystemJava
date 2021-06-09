package coe528.project;
import java.util.*;
import java.io.*;
import static java.lang.System.*;
/**
 *
 * @author dimac
 */
public class BankingSystem {
    
    public static void main(String args[])
    {
        Manager man = new Manager();
        Customer client;
        
        man.AddCustomer("John", "pass");
        CFile cfile = new CFile();
        
        
        client = cfile.ReadFile("asss");
        System.out.println(client);
        System.out.println("Ahh");
        
        

        
    }
}
