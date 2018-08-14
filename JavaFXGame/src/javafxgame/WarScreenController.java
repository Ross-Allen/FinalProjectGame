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
    private int roundsPlayed;

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
        for(int i = 0; i < zdeck.group.size(); i++){
            if(i % 2 == 0){
                zplr1Hand.group.add(zdeck.group.remove(0));
            }else{
                zplr2Hand.group.add(zdeck.group.remove(0));
            }
        }
        //show placeholder
        plr1Hand.setVisible(true);
        plr2Hand.setVisible(true); 
    }//end play handler
    
    @FXML
    private void handleDrawCompareAction(ActionEvent event) throws InterruptedException{
        //validate that players hand have sufficient for dealing
        if(zplr1Hand.group.size() > 0 && zplr2Hand.group.size() > 0){
            //show drawn cards to be prepared.
            zplr1Comparable.group.add(zplr1Hand.dealCard());
            zplr2Comparable.group.add(zplr2Hand.dealCard());


            Image plr1Image = new Image("javafxgame/images/" + (zplr1Comparable.group.get(0).number.getValue() + zplr1Comparable.group.get(0).suit.getSuit()) + ".png");
            Image plr2Image = new Image("javafxgame/images/" + (zplr2Comparable.group.get(0).number.getValue() + zplr2Comparable.group.get(0).suit.getSuit()) + ".png");
            plr1Compare.setImage(plr1Image);
            plr2Compare.setImage(plr2Image);
            plr1Compare.setVisible(true);
            plr2Compare.setVisible(true);

            //sleep 3 seconds
            //Thread.sleep(3000);

            //perform comparison
            int result = (zplr1Comparable.group.get(0)).compareRank(zplr2Comparable.group.get(0));
            //set size for loops
            int size = zplr1Comparable.group.size();

            //determine round winner and transfer cards to winner hand
            switch(result){
                case 1:     //player 1 wins
                    for(int i = 0; i < size; i++){
                        zplr1WinHand.group.add(zplr1Comparable.group.remove(0));
                        zplr1WinHand.group.add(zplr2Comparable.group.remove(0));
                    }
                    System.out.println("Player 1 won the round");
                    roundsPlayed++;
                    break;
                case -1:     //player 2 wins
                    for(int i = 0; i < size; i++){
                        zplr2WinHand.group.add(zplr1Comparable.group.remove(0));
                        zplr2WinHand.group.add(zplr2Comparable.group.remove(0));
                    }
                    System.out.println("Player 2 won the round");
                    roundsPlayed++;
                    break;
                case 0:      //tie (war)
                    war();
                    break;
                default:
                    System.out.println("Error: two cards did not compare properly");
                    break;
            }//end switch
            pileToHand();
        }else{
            pileToHand();
        }
      
    }//end draw and compare method
    
    @FXML
    private void handleQuitAction(ActionEvent event){
    
    }
    
    @FXML
    private void handleInstructionsAction(ActionEvent event){
        
    }
    
    private void pileToHand(){
        if(zplr1Hand.group.size() < 1){
            for(int i = 0; i < zplr1WinHand.group.size(); i++){
                zplr1Hand.group.add(zplr1WinHand.group.remove(0));
            }
        }
        if(zplr2Hand.group.size() < 1){
            for(int i = 0; i < zplr2WinHand.group.size(); i++){
                zplr2Hand.group.add(zplr2WinHand.group.remove(0));
            }
        }
    }
    
    /**
     * War method
     */
    public void war(){
        //local war method attributes
        int result;
        int count = 0;
        
        //Play only when number of rounds is not met and hands are still full and playable
        if((zplr1Hand.group.size() > 0 && zplr1WinHand.group.size() > 0) ||
           (zplr2Hand.group.size() > 0 && zplr2WinHand.group.size() > 0)){
            //deal four cards and compare final set
            while(count < 4){
                //look to see if pile needs to be made hand
                if(zplr1Hand.group.size() > 0 && zplr2Hand.group.size() > 0){
                    zplr1Comparable.group.add(zplr1Hand.dealCard());
                    zplr2Comparable.group.add(zplr2Hand.dealCard());
                    count++;
                }else{
                    pileToHand();
                }
            }
            //Display war hands
            System.out.println("Player 1 comparison: " + zplr1Comparable.toString());
            System.out.println("Player 2 comparison: " + zplr2Comparable.toString());
            
            //perform comparison
            result = (zplr1Comparable.group.get(zplr1Comparable.group.size()-1))
                    .compareRank(zplr2Comparable.group.get(zplr2Comparable.group.size()-1));
            //size for loops
            int comparisonSize = zplr1Comparable.group.size();
            switch(result){
                case 1:      //player 1 wins war
                    for(int i = 0; i < comparisonSize; i++){
                        zplr1WinHand.group.add(zplr1Comparable.group.remove(0));
                        zplr1WinHand.group.add(zplr2Comparable.group.remove(0));
                    }
                    System.out.println("Player 1 won the war");
                    roundsPlayed++;
                    break;
                case -1:      //player 2 wins war
                    for(int i = 0; i < comparisonSize; i++){
                        zplr2WinHand.group.add(zplr1Comparable.group.remove(0));
                        zplr2WinHand.group.add(zplr2Comparable.group.remove(0));
                    }
                    System.out.println("Player 2 won the war");
                    roundsPlayed++;
                    break;
                case 0: //tie (war again)
                    war();
                    break;
                default:
                    System.out.println("Error: result is not 1, -1, or 0");
                    break;
            }//end switch
        }
    }//end war method
    
   
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
