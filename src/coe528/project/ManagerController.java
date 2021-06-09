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
public class ManagerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField mUser;
    @FXML
    private TextField mPass;
    
    @FXML
    private void handleAddButtonAction()
    {
        String user = mUser.getText();
        String pass = mPass.getText();
        
        Manager manager = new Manager();
        manager.AddCustomer(user, pass);
    }
    
    @FXML
    private void handleDeleteButtonAction()
    {
        String user = mUser.getText();
        
        Manager manager = new Manager();
        manager.DeleteCustomer(user);
    }
    
    @FXML
    private void handleLogOutButtonAction(ActionEvent event) throws IOException {
        Parent FXMLManager = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene FXMLManagerScene = new Scene(FXMLManager);
            
        Stage Window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Window.setScene(FXMLManagerScene);
        Window.show();
            
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
