/*
 * CS3230 Final Project War and Game of my Choice
 * Ross Allen
 */
package javafxgame;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX class with start/main
 * @author ross
 */
public class JavaFXGame extends Application {
    
    /**
     * boolean to track if splash has played already
     */
    public static boolean hasSplashLoadedOnce = false;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        URL url = this.getClass().getResource("mainmenu.css");
        if(url == null){
            System.out.println("mainmenu.css not found");
            System.exit(-1);
        }
        String css = url.toExternalForm();
        scene.getStylesheets().add(css);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
