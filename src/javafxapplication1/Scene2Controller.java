/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import DbConn.DatabaseUtil;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author daniel.constantin
 */
public class Scene2Controller implements Initializable {
    Player ply;
    StringProperty dialogH;
        @FXML
    private ProgressBar pbCredibility;
    DoubleProperty CredibilityUpdater = new SimpleDoubleProperty(.5);
    @FXML
    private Label lblCredibility;

   // @FXML
    //private Label lblFinVal;
     @FXML
    private Button btnNextWeek;

    @FXML
    private Accordion accMenu;

    @FXML
    private TitledPane acctpRD;

    @FXML
    private Label lblNewP;

    @FXML
    private Label lblImproveP;

    @FXML
    private Label lblCostR;

    @FXML
    private TitledPane acctpEmployees;
    
    @FXML
    private Label lblYH;
    
    @FXML
    private Label lblWeek;
    //static IntegerProperty() tx =new SimpleIntegerProperty();
    
    @FXML
    private Label lblTeamB;

    @FXML
    private Label lblFires;

    @FXML
    private Label lblBonus;

    @FXML
    private Label lblTrainning;

    @FXML
    private TitledPane acctpMarketing;

    @FXML
    private Label lblTVSpot;

    @FXML
    private Label lblMInsert;

    @FXML
    private Label lblDiscount;

    @FXML
    private Label lblChangeD;

    @FXML
    private Label lblnam;

    @FXML
    private ProgressBar pbMotivation;
     static DoubleProperty MotivationUpdater = new SimpleDoubleProperty();
    @FXML
    private Label lblnam1;

    @FXML
    private Label lblMotivation;

    @FXML
    private Label lblCredibility1;

    @FXML
    private Label lblCredibility11;

    @FXML
    private Label lblnam11;

    @FXML
    private DialogPane dialogAccept;
     

    @FXML
    private ProgressBar pbFinance;
    static DoubleProperty FinancebarUpdater = new SimpleDoubleProperty();


    @FXML
    private void handleButtonAction(ActionEvent event) {

    }
     
    @FXML
    private void OnMouseClicked(MouseEvent e) {
        if(e.getSource()==btnNextWeek){
            ply.addWeek();
            lblWeek.textProperty().bind(new SimpleIntegerProperty(52-(ply.getTurns())).asString());
        }
        if(e.getSource()==lblNewP){
        dialogAccept.setVisible(true);
        dialogH.set("al doilea cacat");    
        }
        if(e.getSource()==lblImproveP){
        dialogAccept.setVisible(true);
        dialogH.set("cacat imbunatatit");
        }
        if(e.getSource()==lblCostR){
            dialogAccept.setVisible(true);
            dialogH.set("cacat cu mot");
        }
        if(e.getSource()==lblTeamB){
        dialogAccept.setVisible(true);
        dialogH.set("Radu e gay");
        }
        if(e.getSource()==lblFires){
        dialogAccept.setVisible(true);
        dialogH.set("Radu e handi");
        }
        if(e.getSource()==lblBonus){
        dialogAccept.setVisible(true);
        dialogH.set("Danciu");
        }
        if(e.getSource()==lblTrainning){
        dialogAccept.setVisible(true);
        dialogH.set("Dirigu are chelia faina");
        }
        if(e.getSource()==lblTVSpot){
        dialogAccept.setVisible(true);
        dialogH.set("nush ce sa mai zic");
        }
        if(e.getSource()==lblMInsert){
        dialogAccept.setVisible(true);
        dialogH.set("lalalala");
        }
        if(e.getSource()==lblChangeD){
        dialogAccept.setVisible(true);
        dialogH.set("imi e foame");
        }
        if(e.getSource()==lblDiscount){
        dialogAccept.setVisible(true);
        dialogH.set("haha am cioco");
        }
    } 
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ply = CurrentPlayer.getCurrentPlayer();
        //lblcacat.setText(ply.get) 
        FinancebarUpdater.set((double)ply.getFinance()/100000);
        pbFinance.progressProperty().bind(FinancebarUpdater);
        CredibilityUpdater.set((double)ply.getCredibility()/100);
        pbCredibility.progressProperty().bind(CredibilityUpdater);
        MotivationUpdater.set((double)ply.getPeople()/100);
        pbMotivation.progressProperty().bind(MotivationUpdater);
        lblnam.setText(ply.getName());
        dialogH = new SimpleStringProperty("un header de cacat");
        
        dialogAccept.headerTextProperty().bind(dialogH);
        lblWeek.textProperty().bind(new SimpleIntegerProperty(52-(ply.getTurns())).asString());
        
        DatabaseUtil dbu = new DatabaseUtil();
        dbu.derbyDBConnection("jdbc:derby:src/javafxapplication1/resources/DBBSim");
    }
    
}
