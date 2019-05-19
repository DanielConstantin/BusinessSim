/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



/**
 *
 * @author Osamu
 */
public class Level1DescriptionController implements Initializable {

    Player ply;
  
    @FXML
    private Button btnOK;

    //@FXML
    //private Label lblDear;

    @FXML
    private Label lblBadLuck;

    //@FXML
    //private ImageView imgcaracter;

   @FXML
    private Label lblnam111;

    @FXML
    private Label lblBadLuck1;

    @FXML
    private Label lblBadLuck11;

    @FXML
    private Label lblnam1111;

    @FXML
    private Label lblnam11111;

    @FXML
    private Label lblnam111111;




    @FXML
    private void handleButtonAction(ActionEvent event) {
        
           Parent root;
            CurrentPlayer.updatePlayer(ply);
            Stage stageTheLabelBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
      
            stageTheLabelBelongs.close();  
            
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ply= CurrentPlayer.ply;
    }

}
