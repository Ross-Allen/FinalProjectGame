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
import javafx.stage.Stage;

/**
 * FXML War Instructions Controller class
 * @author ross
 */
public class WarInstructionsScreenController implements Initializable {

    @FXML
    Button okButton;
    
    /**
     * Go to war screen handler
     * @param event
     * @throws IOException 
     */
    @FXML
    private void goBackToWarScreen(ActionEvent event) throws IOException{
        Parent screen2Parent = FXMLLoader.load(getClass().getResource("WarScreen.fxml"));
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
