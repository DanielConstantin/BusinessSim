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
import javafx.application.Platform;
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
import static javafxapplication1.CurrentPlayer.ply;

/**
 * FXML Controller class
 *
 * @author daniel.constantin
 */
public class LevelDescr2Controller implements Initializable {
   Player Ply;
   @FXML
   private AnchorPane AnchorPane;
    @FXML
    private Button btnOK;
    @FXML
    private Label lblnam111;
    @FXML
    private ImageView imgcaracter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                ply= CurrentPlayer.ply;
        
        
     //  lblDear.setText("Dear "+ply.getName());
       
      if(ply.getGender()==0){
           imgcaracter.setImage(new Image("javafxapplication1/resources/Image-4219.png"));
      }else{
          imgcaracter.setImage(new Image("javafxapplication1/resources/Image-6777.png"));
      }
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
            //ply = CurrentPlayer.ply;
            Parent root ;
            CurrentPlayer.updatePlayer(ply);
        //    Stage stageTheLabelBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Stage stageTheLabelBelongs =(Stage) btnOK.getScene().getWindow();
            CurrentPlayer.ply=null;
            CurrentPlayer.PlyactionList=null;
     try {
          //    Platform.runLater();
              root = FXMLLoader.load(getClass().getResource("javafxapplication1/Scene2.fxml"));
              Scene scene = new Scene(root);
              
              stageTheLabelBelongs.setScene(scene);
               
            } catch (IOException ex) {
                 Logger.getLogger(Level1DescriptionController.class.getName()).log(Level.SEVERE, null, ex);
              
            }  
            
    }
    }
    

