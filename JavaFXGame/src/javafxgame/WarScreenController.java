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

    @FXML
    ImageView warDeck;   
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        
    }
    
    
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image("javafxgame/images/back.png");
        warDeck.setImage(image);
        
    }    
    
}
