/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimac
 */
public class FXMLCustomerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Customer cus;
    @FXML
    private TextField DnP;
    
    @FXML
    private Label Status;
    
    @FXML
    private void handleDepositButtonAction()
    {
        String s = DnP.getText();
        int number = Integer.parseInt(s);
        cus.account.DepositMoney(number);
        Status.setText(cus.account.Status());
    }
    
    @FXML
    private void handleWithdrawButtonAction()
    {
        String s = DnP.getText();
        int number = Integer.parseInt(s);
        cus.account.WithdrawMoney(number);
        Status.setText(cus.account.Status());
    }
    
    @FXML
    private void handleOnlinePurchaseButtonAction()
    {
        String s = DnP.getText();
        int number = Integer.parseInt(s);
        cus.account.OnlinePurchase(number);
        Status.setText(cus.account.Status());
    }
    
    @FXML
    private void handleBalanceButtonAction()
    {
        DnP.setText(String.valueOf(cus.account.GetBalance()));
        Status.setText(cus.account.Status());
    }
    
    @FXML
    private void handleLogOutButtonAction(ActionEvent event) throws IOException {
        
        CFile cfile = new CFile();
        cfile.WriteFile(cus);
        Parent FXMLManager = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLManagerScene = new Scene(FXMLManager);
            
        Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(FXMLManagerScene);
        Window.show();
            
    }
    
    public void SetCustomer(Customer cust)
    {
        cus = cust;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
