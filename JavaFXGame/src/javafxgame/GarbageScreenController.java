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
import javafx.scene.image.ImageView;
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
   
    private void handleShuffleAndPlay(ActionEvent event){
    
    }// end shuffle and play method
    
    
    
    
    
    
    
    
    
    
    
    
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
        
        
    }    
    
}
