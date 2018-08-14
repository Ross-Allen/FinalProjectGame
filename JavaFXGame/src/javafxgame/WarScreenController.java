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
import javafx.scene.text.Text;
import javax.annotation.Resources;

/**
 * FXML Controller class
 *
 * @author ross
 */
public class WarScreenController implements Initializable {
    
    GameOfWar gow;
    
    //card pile declarations
    @FXML
    Text youText;
    @FXML
    Button btnQuit;
    @FXML
    Button btnInstructions;
    @FXML
    Button btnDrawCompare;
    @FXML
    Button btnPlay;
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
    private void handlePlayAction(ActionEvent event){
        //set play button and deck visibility to false
        btnPlay.setVisible(false);
        warDeck.setVisible(false);
        
        
        
        
    }
    
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
        
        Image image = new Image("javafxgame/images/back.png");
        warDeck.setImage(image);
        //Initialize all pile visibility properties.
        warDeck.setVisible(true);
        plr1WinHand.setVisible(false);
        plr2WinHand.setVisible(false);
        plr1Hand.setVisible(false);
        plr2Hand.setVisible(false);
        plr1Compare.setVisible(false);
        plr2Compare.setVisible(false);
        plr1WarCard1.setVisible(false);
        plr1WarCard2.setVisible(false);
        plr1WarCard3.setVisible(false);
        plr2WarCard1.setVisible(false);
        plr2WarCard2.setVisible(false);
        plr2WarCard3.setVisible(false);
        plr1WarCompare.setVisible(false);
        plr2WarCompare.setVisible(false);
        youText.setVisible(false);
        btnDrawCompare.setVisible(false);
        btnPlay.setVisible(true);
        
    }    
    
}
