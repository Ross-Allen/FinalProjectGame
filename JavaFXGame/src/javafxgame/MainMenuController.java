/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author ross
 */
public class MainMenuController implements Initializable {
    
    @FXML
    AnchorPane root;
    
    public static AnchorPane rootPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(!JavaFXGame.hasSplashLoadedOnce){
            loadSplash();
        }
        rootPane = root;
    }  
    
    private void loadSplash(){
        try {
            JavaFXGame.hasSplashLoadedOnce = true;
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Splash.fxml"));
            root.getChildren().setAll(pane);
            FadeTransition in = new FadeTransition(Duration.seconds(4), pane);
            in.setFromValue(0);
            in.setToValue(1);
            in.setCycleCount(1);
            
            FadeTransition out = new FadeTransition(Duration.seconds(4), pane);
            out.setFromValue(1);
            out.setToValue(1);
            out.setCycleCount(1);
            
            in.play();
            in.setOnFinished(e->{
                out.play();
            });
            out.setOnFinished(e->{
                try {
                    AnchorPane main = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                    root.getChildren().setAll(main);
                } catch (IOException ex) {
                    Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**
     * Go to War Screen
     * @param event
     * @throws IOException 
     */
    @FXML
    private void goToWarScreen(ActionEvent event) throws IOException{
        Parent screen2Parent = FXMLLoader.load(getClass().getResource("WarScreen.fxml"));
        Scene screen2Scene = new Scene(screen2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(screen2Scene);
        window.show();
    }
    
    /**
     * Go to Garbage Screen
     * @param event
     * @throws IOException 
     */
    @FXML
    private void goToGarbageScreen(ActionEvent event) throws IOException{
        Parent screen2Parent = FXMLLoader.load(getClass().getResource("GarbageScreen.fxml"));
        Scene screen2Scene = new Scene(screen2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(screen2Scene);
        window.show();
    }
    
    @FXML
    private void exitHandler(ActionEvent event){
        System.exit(0);
    }
    
}
