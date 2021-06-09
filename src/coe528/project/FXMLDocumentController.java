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
 *
 * @author dimac
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    
    @FXML
    private void handleLogInButtonAction(ActionEvent event) throws IOException {
        String user = Username.getText();
        String pass = Password.getText();
        
        if(user.equals("admin") && pass.equals("admin"))
        {
            System.out.println("You are the Admin");
            
            Parent FXMLManager = FXMLLoader.load(getClass().getResource("Manager.fxml"));
            Scene FXMLManagerScene = new Scene(FXMLManager);
            
            Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
            Window.setScene(FXMLManagerScene);
            Window.show();
            
        }
        else
        {
            CFile cfile = new CFile();
            Customer client;
            client = cfile.ReadFile(user);
            
            if(client == null)
            {
                System.out.println("Error - User Doesnt Exit");
            }
            else
            {
                if(client.Password.equals(pass))
                {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("FXMLCustomer.fxml"));
                    Parent FXMLManager = loader.load();
                    
                    
                    //Parent FXMLManager = FXMLLoader.load(getClass().getResource("FXMLCustomer.fxml"));
                    Scene FXMLManagerScene = new Scene(FXMLManager);
                    
                    FXMLCustomerController controller = loader.getController();
                    controller.cus = client;
            
                    Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Window.setScene(FXMLManagerScene);
                    Window.show();
                }
                else{
                    System.out.println("Wrong Password");
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
