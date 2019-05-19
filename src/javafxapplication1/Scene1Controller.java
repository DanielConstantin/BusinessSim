/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;
import static javafxapplication1.CurrentPlayer.istoricF;


/**
 *
 * @author Osamu
 */
public class Scene1Controller implements Initializable {

    Player ply;
    Alert alertEvent;
    @FXML
    private Label label;
    @FXML
    private TextField txtPersName;
    @FXML
    private Button button;
    @FXML
    private Label lblyrn;
    @FXML
    private Button btnLogo;
    @FXML
    private ImageView imgcaracter;
    
    @FXML
    private ImageView imageView;

    @FXML
    private TextField txtnume;
   @FXML
    private DialogPane dialogDescr;

    @FXML
    private Label lblAdv;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private RadioButton rbMale;

    @FXML
    private void WhenYouWrite(KeyEvent e) {
        if(e.getText()!=""){
          lblAdv.setText("");
 
        }
       
    }
    @FXML
    private void handleRadioButtonSel(MouseEvent e){
        if(e.getSource()==rbMale){             
            imgcaracter.setImage(new Image("javafxapplication1/resources/Image-6777.png"));
        } else if(e.getSource()==rbFemale){
            imgcaracter.setImage(new Image("javafxapplication1/resources/Image-4219.png"));
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        //  String plyN = null;
        int gender;
        if (rbFemale.isSelected() == true) {
            gender = 0;
        } else {
            gender = 1;
        }
        if (txtnume.lengthProperty().intValue() > 0 && txtPersName.lengthProperty().intValue() > 0) {
            ply = new Player(txtnume.getText(), txtPersName.getText(), 0, 50000, 50, 50, gender);
            Stage stageTheLabelBelongs = (Stage) button.getScene().getWindow();
            
            CurrentPlayer.updatePlayer(ply);
            CurrentPlayer.istoricF.add(CurrentPlayer.SeriesF);
            ActionHandling.createActionList();
            ActionHandling.createEvList();
           System.out.println(ActionHandling.eventList.get(2).getEvMessage());
            stageTheLabelBelongs.setTitle("Business Simulator");
             alertEvent.setHeaderText("");     
           

     
           
              try {
                 Parent root2 = FXMLLoader.load(getClass().getResource("Level1Description.fxml"));
                  Stage stage2 = new Stage();
                  Scene scene = new Scene(root2);
                 stage2.setScene(scene);
                 stage2.setTitle("Business Simulator");
                stage2.showAndWait();
                Parent root  = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
                stageTheLabelBelongs.setScene(new Scene(root));  
                } catch (IOException ex) {
                Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                
             
            
            
            
        } else {
            lblAdv.setText("You have to fill all required fields!!!");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertEvent = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
        dialogDescr = alertEvent.getDialogPane();
        dialogDescr.getStylesheets().add(getClass().getResource("resources/Alert.css").toExternalForm());
        dialogDescr.autosize();
        dialogDescr.setPrefSize(400, 400);
       
    }

}
