/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgame;

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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ross
 */
public class GarbageScreenController implements Initializable {

    @FXML
    Button btnInstruction;
    @FXML
    Button btnBack;
    @FXML
    Button btnShuffleAndPlay;
    
    //label card imageview for players
    @FXML
    ImageView plr1Pos1;
    @FXML
    ImageView plr1Pos2;
    @FXML
    ImageView plr1Pos3;
    @FXML
    ImageView plr1Pos4;
    @FXML
    ImageView plr1Pos5;
    @FXML
    ImageView plr1Pos6;
    @FXML
    ImageView plr1Pos7;
    @FXML
    ImageView plr1Pos8;
    @FXML
    ImageView plr1Pos9;
    @FXML
    ImageView plr1Pos10;
    @FXML
    ImageView plr2Pos1;
    @FXML
    ImageView plr2Pos2;
    @FXML
    ImageView plr2Pos3;
    @FXML
    ImageView plr2Pos4;
    @FXML
    ImageView plr2Pos5;
    @FXML
    ImageView plr2Pos6;
    @FXML
    ImageView plr2Pos7;
    @FXML
    ImageView plr2Pos8;
    @FXML
    ImageView plr2Pos9;
    @FXML
    ImageView plr2Pos10;
    @FXML
    ImageView discardPile;
    @FXML
    ImageView drawPile;
    @FXML
    ImageView deck;
    @FXML
    Text discardText;
    @FXML
    Text drawText;
    
    private GroupOfCards zDeck;
    private GroupOfCards zDiscard;
    private GroupOfCards zDraw;
    private GroupOfCards zPlr1Hand;
    private GroupOfCards zPlr2Hand;
    
   
    @FXML
    private void handleShuffleAndPlay(ActionEvent event){
        plr1Pos1.setVisible(true);
        plr1Pos2.setVisible(true);
        plr1Pos3.setVisible(true);
        plr1Pos4.setVisible(true);
        plr1Pos5.setVisible(true);
        plr1Pos6.setVisible(true);
        plr1Pos7.setVisible(true);
        plr1Pos8.setVisible(true);
        plr1Pos9.setVisible(true);
        plr1Pos10.setVisible(true);
        plr2Pos1.setVisible(true);
        plr2Pos2.setVisible(true);
        plr2Pos3.setVisible(true);
        plr2Pos4.setVisible(true);
        plr2Pos5.setVisible(true);
        plr2Pos6.setVisible(true);
        plr2Pos7.setVisible(true);
        plr2Pos8.setVisible(true);
        plr2Pos9.setVisible(true);
        plr2Pos10.setVisible(true);
        discardPile.setVisible(true);
        drawPile.setVisible(true);
        discardText.setVisible(true);
        drawText.setVisible(true);
        deck.setVisible(false);
        btnShuffleAndPlay.setVisible(false);
        
        //deck count before shuffle
        System.out.println("Deck has total of " + zDeck.group.size() + " cards.");
        //create deck and shuffle
        zDeck.shuffle();
        System.out.println("Deck has total of " + zDeck.group.size() + " cards after shuffle.");

        //split deck
        for(int i = 0; i < 20; i++){
            if(i % 2 == 0){
                zPlr1Hand.group.add(zDeck.group.remove(0));
            }else{
                zPlr2Hand.group.add(zDeck.group.remove(0));
            }
        }
        System.out.println("Player 1's hand has " + zPlr1Hand.group.size() + " cards.");
        System.out.println("Player 2's hand has " + zPlr2Hand.group.size() + " cards.");
        
        //draw top card of deck to discard.
        zDraw.group = zDeck.group;
        zDiscard.group.add(zDraw.dealCard());
        Image discardImage = new Image("javafxgame/images/" + (zDiscard.group.get(0).number.getValue() + zDiscard.group.get(0).suit.getSuit()) + ".png");
        discardPile.setImage(discardImage);
    }// end shuffle and play method
    
    @FXML
    private void handleDiscardClick(MouseEvent event){
        
    }
     
    @FXML
    private void handleDrawClick(MouseEvent event){
        
    }
    
    
    
    
    
    /**
     * back to main method
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleBackToMainAction(ActionEvent event) throws IOException{
        Parent screen2Parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene screen2Scene = new Scene(screen2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(screen2Scene);
        window.show();
    }
    /**
     * Instructions window button handler
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleInstructionAction(ActionEvent event) throws IOException{
        Parent screen2Parent = FXMLLoader.load(getClass().getResource("GarbageInstructionsScreen.fxml"));
        Scene screen2Scene = new Scene(screen2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(screen2Scene);
        window.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        plr1Pos1.setVisible(false);
        plr1Pos2.setVisible(false);
        plr1Pos3.setVisible(false);
        plr1Pos4.setVisible(false);
        plr1Pos5.setVisible(false);
        plr1Pos6.setVisible(false);
        plr1Pos7.setVisible(false);
        plr1Pos8.setVisible(false);
        plr1Pos9.setVisible(false);
        plr1Pos10.setVisible(false);
        plr2Pos1.setVisible(false);
        plr2Pos2.setVisible(false);
        plr2Pos3.setVisible(false);
        plr2Pos4.setVisible(false);
        plr2Pos5.setVisible(false);
        plr2Pos6.setVisible(false);
        plr2Pos7.setVisible(false);
        plr2Pos8.setVisible(false);
        plr2Pos9.setVisible(false);
        plr2Pos10.setVisible(false);
        discardPile.setVisible(false);
        drawPile.setVisible(false);
        discardText.setVisible(false);
        drawText.setVisible(false);
        deck.setVisible(true);
        btnInstruction.setVisible(true);
        btnBack.setVisible(true);
        btnShuffleAndPlay.setVisible(true);
        //initialize 
        zDeck = new Deck();
        zDiscard = new Hand();
        zDraw = new Hand();
        zPlr1Hand = new Hand();
        zPlr2Hand = new Hand();
        
    }    
    
}
