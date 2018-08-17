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
 * Main Menu Screen Controller Class
 * @author ross
 */
public class MainMenuController implements Initializable {
    
    @FXML
    AnchorPane root;
    
    /**
     * ties UI to created splash pane
     */
    public static AnchorPane rootPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Check to see if splash has already ran once
        if(!JavaFXGame.hasSplashLoadedOnce){
            loadSplash();
        }
        //init
        rootPane = root;
    }  
    
    /**
     * Load splash screen method
     * Special credit to you tube tutorial "Genuine Coder" where credit is due
     */
    private void loadSplash(){
        try {
            //set true so it doesn't loop
            JavaFXGame.hasSplashLoadedOnce = true;
            //create new pane
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Splash.fxml"));
            //set pane 
            root.getChildren().setAll(pane);
            //set transition values
            FadeTransition in = new FadeTransition(Duration.seconds(4), pane);
            in.setFromValue(0);
            in.setToValue(1);
            in.setCycleCount(1);
            //use constant fade out acting as timer
            FadeTransition out = new FadeTransition(Duration.seconds(4), pane);
            out.setFromValue(1);
            out.setToValue(1);
            out.setCycleCount(1);
            //start transition
            in.play();
            in.setOnFinished(e->{
                out.play();
            });
            //set root to main menu screen
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
    
    /**
     * exit handler
     * @param event 
     */
    @FXML
    private void exitHandler(ActionEvent event){
        System.exit(0);
    }
    
}
