/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgame;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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
    @FXML
    Text plr1Turn;
    @FXML
    Text plr2Turn;
    
    private GroupOfCards zDeck;
    private GroupOfCards zDiscard;
    private GroupOfCards zDraw;
    private GroupOfCards zPlr1Hand;
    private GroupOfCards zPlr2Hand;
    private boolean isPlayer1Turn = true;
    private Card returnedCard;
    private boolean[] zPlr1FlagList;
    private boolean[] zPlr2FlagList;
   
    @FXML
    private void handleShuffleAndPlay(ActionEvent event){
        plr1Turn.setVisible(true);
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
        if(isPlayer1Turn){
            //remove card from top of discard pile
            Card returnedCard = zDiscard.dealCard();
            
            do{
                int cardValue = returnedCard.number.getValue();
                if(cardValue == 14){
                    cardValue = 1;
                }
                //check flag
                if(zPlr1FlagList[cardValue - 1]){ 
                    Collections.reverse(zDiscard.group);
                    zDiscard.group.add(returnedCard);
                    Collections.reverse(zDiscard.group);
                    break;
                }
                //call placeCard method
                returnedCard = placeCard(returnedCard,zPlr1Hand);
                //put returned card into discard
                Collections.reverse(zDiscard.group);
                zDiscard.group.add(returnedCard);
                Collections.reverse(zDiscard.group);
                //reset image
                Image discardImage = new Image("javafxgame/images/" + (returnedCard.number.getValue() + returnedCard.suit.getSuit()) + ".png");
                discardPile.setImage(discardImage);
            }while((returnedCard.number.getValue() >= 1 &&
                    returnedCard.number.getValue() <= 10) ||
                    returnedCard.number.getValue() == 14); 
        }else{
            //remove card from top of discard pile
            Card returnedCard = zDiscard.dealCard();
            
            do{
                int cardValue = returnedCard.number.getValue();
                if(cardValue == 14){
                    cardValue = 1;
                }
                //check flag
                if(zPlr2FlagList[cardValue - 1]){ 
                    Collections.reverse(zDiscard.group);
                    zDiscard.group.add(returnedCard);
                    Collections.reverse(zDiscard.group);
                    break;
                }
                //call placeCard method
                returnedCard = placeCard(returnedCard,zPlr2Hand);
                //put returned card into discard
                Collections.reverse(zDiscard.group);
                zDiscard.group.add(returnedCard);
                Collections.reverse(zDiscard.group);
                //reset image
                Image discardImage = new Image("javafxgame/images/" + (returnedCard.number.getValue() + returnedCard.suit.getSuit()) + ".png");
                discardPile.setImage(discardImage);
            }while((returnedCard.number.getValue() >= 1 &&
                    returnedCard.number.getValue() <= 10) ||
                    returnedCard.number.getValue() == 14); 
        }
        //switch turnes
        isPlayer1Turn = !isPlayer1Turn;
        if(isPlayer1Turn){
            plr1Turn.setVisible(true);
            plr2Turn.setVisible(false);
        }else{
            plr1Turn.setVisible(false);
            plr2Turn.setVisible(true);
        }
        
        
    }
    
    private Card placeCard(Card card, GroupOfCards plrHand){ 
        //temp return card
        Card returnCard = card;
        //get card value
        int cardValue = card.number.getValue();
        //if Ace change to 1
        if(cardValue == 14){
            cardValue = 1;
        }
        if(isPlayer1Turn){
            for(int i = 1; i <= plrHand.group.size(); i++){
                //if card can go somewhere
                if(cardValue == i){
                    //flag spot
                    zPlr1FlagList[i-1] = true;
                    switch(cardValue){
                        case 1:
                            Image curr1 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos1.setImage(curr1);
                            break;
                        case 2: 
                            Image curr2 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos2.setImage(curr2);
                            break;
                        case 3:
                            Image curr3 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos3.setImage(curr3);
                            break;
                        case 4:
                            Image curr4 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos4.setImage(curr4);
                            break;
                        case 5:
                            Image curr5 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos5.setImage(curr5);
                            break;
                        case 6:
                            Image curr6 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos6.setImage(curr6);
                            break;
                        case 7:
                            Image curr7 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos7.setImage(curr7);
                            break;
                        case 8:
                            Image curr8 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos8.setImage(curr8);
                            break;
                        case 9:
                            Image curr9 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos9.setImage(curr9);
                            break;
                        case 10:
                            Image curr10 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr1Pos10.setImage(curr10);
                            break;
                        default:break;
                    }//end switch
                    //get card that is getting replaced
                    returnCard = plrHand.group.get(i-1);
                    plrHand.group.add((i-1),card);
                }       
            }
        }else{
            for(int i = 1; i <= plrHand.group.size(); i++){
                //if card can go somewhere
                if(cardValue == i){
                    //flag spot
                    zPlr2FlagList[i-1] = true;
                    switch(cardValue){
                        case 1:
                            Image curr1 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos1.setImage(curr1);
                            break;
                        case 2: 
                            Image curr2 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos2.setImage(curr2);
                            break;
                        case 3:
                            Image curr3 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos3.setImage(curr3);
                            break;
                        case 4:
                            Image curr4 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos4.setImage(curr4);
                            break;
                        case 5:
                            Image curr5 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos5.setImage(curr5);
                            break;
                        case 6:
                            Image curr6 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos6.setImage(curr6);
                            break;
                        case 7:
                            Image curr7 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos7.setImage(curr7);
                            break;
                        case 8:
                            Image curr8 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos8.setImage(curr8);
                            break;
                        case 9:
                            Image curr9 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos9.setImage(curr9);
                            break;
                        case 10:
                            Image curr10 = new Image("javafxgame/images/" + (card.number.getValue() + card.suit.getSuit()) + ".png");
                            plr2Pos10.setImage(curr10);
                            break;
                        default:break;
                    }//end switch
                    //get card that is getting replaced
                    returnCard = plrHand.group.get(i-1);
                    plrHand.group.add((i-1),card);
                }       
            }
        }
        return returnCard;
    }
    
    @FXML
    private void handleDrawClick(MouseEvent event){
        //draw pile length 1 hide pile after draw
        if(zDraw.group.size() <= 1){
        }else{
        
        }
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
        plr1Turn.setVisible(false);
        plr2Turn.setVisible(false);
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
        isPlayer1Turn = true;
        zPlr1FlagList = new boolean[10];
        zPlr2FlagList = new boolean[10];
        for(int i = 0; i < 10; i++){
            zPlr1FlagList[i] = false;
            zPlr2FlagList[i] = false;
        }
        
        
    }    
    
}
