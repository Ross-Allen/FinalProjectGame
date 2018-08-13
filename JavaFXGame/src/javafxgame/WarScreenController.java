/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.annotation.Resources;

/**
 * FXML Controller class
 *
 * @author ross
 */
public class WarScreenController implements Initializable {

    //card pile declarations
    @FXML
    ImageView warDeck; 
    @FXML
    ImageView plr1Hand;
    @FXML
    ImageView plr2Hand;
    @FXML
    ImageView plr1Compare;
    @FXML 
    ImageView plr2Compare;
    @FXML
    ImageView plr1WinHand;
    @FXML 
    ImageView plr2WinHand;
    @FXML
    ImageView plr1WarCard1;
    @FXML
    ImageView plr1WarCard2;
    @FXML
    ImageView plr1WarCard3;
    @FXML
    ImageView plr2WarCard1;
    @FXML
    ImageView plr2WarCard2;
    @FXML
    ImageView plr2WarCard3;
    @FXML
    ImageView plr1WarCompare;
    @FXML
    ImageView plr2WarCompare;
    
    @FXML
    private void handleDrawCompareAction(ActionEvent event){
        
    }
    
    @FXML
    private void handleQuitAction(ActionEvent event){
    
    }
    
    @FXML
    private void handleInstructionsAction(ActionEvent event){
        
    }
    
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image("javafxgame/images/back.png");
        warDeck.setImage(image);
        warDeck.setVisible(false);
        
    }    
    
}
