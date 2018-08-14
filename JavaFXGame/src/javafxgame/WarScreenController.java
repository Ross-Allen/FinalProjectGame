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

/**
 * FXML Controller class
 *
 * @author ross
 */
public class WarScreenController implements Initializable {
    
    private GroupOfCards zdeck;
    private GroupOfCards zplr1Comparable;
    private GroupOfCards zplr2Comparable;
    private GroupOfCards zplr1WinHand;
    private GroupOfCards zplr2WinHand;
    private GroupOfCards zplr1Hand;
    private GroupOfCards zplr2Hand;

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
        //set play button, draw button, and deck visibility.
        btnPlay.setVisible(false);
        warDeck.setVisible(false);
        btnDrawCompare.setVisible(true);
        
        //create deck and shuffle
        zdeck.shuffle();
        //split deck
//        for(int i = 0; i < zdeck.group.size(); i++){
//            if(i % 2 == 0){
//                zplr1Hand.group.add(zdeck.group.remove(0));
//            }else{
//                zplr2Hand.group.add(zdeck.group.remove(0));
//            }
//        }
        //show placeholder
        plr1Hand.setVisible(true);
        plr2Hand.setVisible(true); 
    }//end play handler
    
    @FXML
    private void handleDrawCompareAction(ActionEvent event){
//        Card plr1Card = zplr1Hand.dealCard();
//        Card plr2Card = zplr2Hand.dealCard();
//        Image plr1Image = new Image("javafxgame/images/" + (plr1Card.number.getValue() + plr1Card.suit.getSuit()) + ".png");
//        Image plr2Image = new Image("javafxgame/images/" + (plr2Card.number.getValue() + plr2Card.suit.getSuit()) +".png");
//        plr1Hand.setImage(plr1Image);
//        plr1Hand.setImage(plr2Image);
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
        
        zdeck = new Deck();
        zplr1Comparable = new Hand();
        zplr2Comparable = new Hand();
        zplr1WinHand = new Hand();
        zplr2WinHand = new Hand();
        zplr1Hand = new Hand();
        zplr2Hand = new Hand();
        
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
