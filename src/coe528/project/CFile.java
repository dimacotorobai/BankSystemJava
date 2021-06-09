/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.io.*;
import java.lang.*;
import java.util.*;
/**
 *
 * @author dimac
 */
public class CFile {
    
    public void WriteFile(Customer cust)
    {
        try{
                FileWriter fw = new FileWriter("" + cust.Username + ".txt");
                PrintWriter pw = new PrintWriter(fw);

                pw.println(cust.Username);
                pw.println(cust.Password);
                pw.println(cust.account.money);
                pw.println(cust.account.Status());

                pw.close();
                fw.close();
            }
            catch(Exception e)
            {
             System.out.println("Exits");   
            }
    }
    public Customer ReadFile(String Username)
    {
        Customer cus = null;
        try{
            FileReader fr = new FileReader("" + Username + ".txt");
            BufferedReader br = new BufferedReader(fr);
            
            String uUsername, uPassword;
            
            uUsername = br.readLine();
            uPassword = br.readLine();
            
            cus = new Customer(uUsername, uPassword);
            
            System.out.println("IDK");
            cus.account.money = Integer.parseInt(br.readLine());
            cus.account.szStatus = br.readLine();
            
            br.close();
            fr.close();
            
            return cus;
            
            
        }
        catch(Exception a)
        {
            System.out.println("Error1");
        }
        
        return cus;
    }
}
