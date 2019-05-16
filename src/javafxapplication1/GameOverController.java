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
 * @author daniel.constantin
 */
public class GameOverController implements Initializable {

    Player ply;
    @FXML
    private Label lblDear;
    @FXML
    private Label lblnam111;
  
  
    @FXML
    private Button btnOK;

    
    @FXML
    private ImageView imgcaracter;

   
    @FXML
    private Label lblTtitlu;

    @FXML
    private Label lblBadLuck;



    @FXML
    private void handleButtonAction(ActionEvent event) {
        
          //Parent root;
            CurrentPlayer.updatePlayer(ply);
            Stage stageTheLabelBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
            CurrentPlayer.ply=null;
            CurrentPlayer.PlyactionList=null;
     try {
            
               Parent  root =FXMLLoader.load(getClass().getClassLoader().getResource("Scene1.fxml"));
                
              stageTheLabelBelongs.setScene(new Scene(root));
               
            } catch (IOException ex) {
                 Logger.getLogger(GameOverController.class.getName()).log(Level.SEVERE, null, ex);
              
            }  
            
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ply= CurrentPlayer.ply;
        
        
       lblDear.setText("Dear "+ply.getName());
       
      if(ply.getGender()==0){
           imgcaracter.setImage(new Image("javafxapplication1/resources/Image-4219.png"));
      }else{
          imgcaracter.setImage(new Image("javafxapplication1/resources/Image-6777.png"));
      }
    }

}
