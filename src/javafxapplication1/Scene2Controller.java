/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

//import DbConn.DatabaseUtil;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxapplication1.ActionHandling;
/**
 *
 * @author daniel.constantin
 */
public class Scene2Controller implements Initializable {
    private Player ply;
    StringProperty dialogH;
    static int actionNo;
    
    Alert dialogAlert;
    Alert alertReject;
    Alert alertEvent;
    
    
    @FXML
    private ProgressBar pbCredibility;
    DoubleProperty CredibilityUpdater;
    @FXML
    private ProgressBar pbMotivation;
     private DoubleProperty MotivationUpdater;
    @FXML
    private Label lblFounds;
    private IntegerProperty foundsUpdater;
    @FXML
    private Label lblnam11;
   // Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private ProgressBar pbFinance;
    private DoubleProperty FinancebarUpdater;
    //
    
    @FXML
    private Label lblYH;

    @FXML
    private Label lblWeek;

   
    @FXML
    private Label lblCredibility;

    

    @FXML
    private Label lblFinance;

    @FXML
    private Button btnNextWeek;

    @FXML
    private Label lblnam;



    @FXML
    private BarChart chartFinancial;

    @FXML
    private Label lblMotivation;

    @FXML
    private Label lblCredibility1;

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
    private TitledPane acctpMarketing;

    @FXML
    private Label lblTVSpot;

    @FXML
    private Label lblMInsert;

    @FXML
    private Label lblOnline;

    @FXML
    private Label lblChangeD;

    @FXML
    private TitledPane acctpEmployees;

    @FXML
    private Label lblTeamB;

    @FXML
    private Label lblSoftware;

    @FXML
    private Label lblBonus;

    @FXML
    private Label lblTrainning;


    @FXML
    private DialogPane dialogAccept;

    @FXML
    private DialogPane dialogReject;
    
     @FXML
    private DialogPane dialogEvent;

    @FXML
    private Label lblcredibilprc;

    @FXML
    private Label lblfinprc;

    @FXML
    private Label lblmotivprc;
    
    
 

    
 
 //   @FXML
//    private Label lblnam1;

    
     
    @FXML
    private void OnMouseClicked(MouseEvent e) {
         
        CurrentPlayer.updatePlayer(ply);
        if (e.getSource() == btnNextWeek) {
            ActionHandling.addWeek();
            ply = CurrentPlayer.ply;
            if (ply.getTurns() == 53) {
                if (ply.getFinance() < 100000) {
                    endOfLevel("GameOver.fxml");
                } else {
                    endOfLevel("LevelComplete.fxml");
                }
            }
            lblWeek.textProperty().bind(new SimpleIntegerProperty(52-(ply.getTurns())).asString());
            lblFounds.textProperty().bind(foundsUpdater.asString());
           CurrentPlayer.SeriesF.getData().add(new XYChart.Data<>(Integer.toString(ply.getTurns()),Integer.valueOf(ply.getFinance())));
           
           //ply.updatePlayer(ply);
           for(int m=0; m<ActionHandling.lblenable.length;m++){
           
               switch(m){
                   case 0: if(ActionHandling.lblenable[m]==0) {lblNewP.setDisable(false);}else {lblNewP.setDisable(true);}
                   case 1: if(ActionHandling.lblenable[m]==0) {lblImproveP.setDisable(false);}else {lblImproveP.setDisable(true);}
                   case 2: if(ActionHandling.lblenable[m]==0) {lblCostR.setDisable(false);}else {lblCostR.setDisable(true);}
                   case 3: if(ActionHandling.lblenable[m]==0) {lblTeamB.setDisable(false);}else {lblTeamB.setDisable(true);}
                   case 4: if(ActionHandling.lblenable[m]==0) {lblBonus.setDisable(false);}else {lblBonus.setDisable(true);}
                   case 5: if(ActionHandling.lblenable[m]==0) {lblTrainning.setDisable(false);}else {lblTrainning.setDisable(true);}
                   case 6: if(ActionHandling.lblenable[m]==0) {lblTVSpot.setDisable(false);}else {lblTVSpot.setDisable(true);}
                   case 7: if(ActionHandling.lblenable[m]==0) {lblMInsert.setDisable(false);}else {lblMInsert.setDisable(true);}
                   case 8: if(ActionHandling.lblenable[m]==0) {lblChangeD.setDisable(false);}else {lblChangeD.setDisable(true);}
                   case 9: if(ActionHandling.lblenable[m]==0) {lblOnline.setDisable(false);}else {lblOnline.setDisable(true);}
                   case 10:if(ActionHandling.lblenable[m]==0) {lblSoftware.setDisable(false);}else {lblSoftware.setDisable(true);}
                   default:
 
               }
           }
           updateVisuals();
           
           if(ply.getTurns()>1){
           int chooseEv =(int)(Math.random()*ActionHandling.MAX_EVENT);
           alertEvent.setHeaderText(ActionHandling.eventList.get(chooseEv).getEvName());     
           alertEvent.setContentText(ActionHandling.eventList.get(chooseEv).getEvMessage());
           Optional<ButtonType> optionn = alertEvent.showAndWait();         
          
             if (optionn.get() == ButtonType.CLOSE) {
                 System.out.println(chooseEv);
                 System.out.println(ActionHandling.eventList.get(chooseEv).getEvFinancial());
                 ply.setFinance(ActionHandling.eventList.get(chooseEv).getEvFinancial()+ply.getFinance());
                 CurrentPlayer.updatePlayer(ply);
                 alertEvent.close();
            } 
           }
        }
        if(e.getSource()==lblNewP){
        implementAction(0,lblNewP);
        }
        if(e.getSource()==lblImproveP){
         implementAction(1,lblImproveP);
        }
        if(e.getSource()==lblCostR){
        implementAction(2, lblCostR );
        }
        if(e.getSource()==lblTeamB){
          implementAction(3, lblTeamB );
        }
        if(e.getSource()==lblSoftware){
         implementAction(10, lblSoftware );
        }
        if(e.getSource()==lblBonus){
        implementAction(4, lblBonus );
        }
        if(e.getSource()==lblTrainning){
        implementAction(5, lblTrainning );
        }
        if(e.getSource()==lblTVSpot){
        implementAction(6, lblTVSpot );
        }
        if(e.getSource()==lblMInsert){
        implementAction(7, lblMInsert );
        }
        if(e.getSource()==lblChangeD){
        implementAction(8, lblChangeD );
        }
        if(e.getSource()==lblOnline){
        implementAction(9, lblOnline );
        }
        ply = CurrentPlayer.ply;
        updateVisuals();
    } 
   
    private void implementAction(int actionno, Label lbl ){
        actionNo =actionno;
        dialogAlert.setHeaderText(ActionHandling.actionList.get(actionNo).getMessageHeader());     
        dialogAlert.setContentText(ActionHandling.actionList.get(actionNo).getMessageBody());
        Optional<ButtonType> option = dialogAlert.showAndWait();
         CurrentPlayer.updatePlayer(ply);
         if (option.get() == null) {
             dialogAlert.close();
         } else if (option.get() == ButtonType.APPLY) {
         if(ActionHandling.applyAction(actionNo)==true){ 
              ply = CurrentPlayer.ply;
             lbl.setDisable(true);
         }else{
             alertReject.setHeaderText("Insuficient Fonds!!!");     
             alertReject.setContentText("You don't have enought money to implement this action!");
             Optional<ButtonType> optionR = alertReject.showAndWait();
             if (optionR.get() == null) {
                } else if (optionR.get() == ButtonType.CANCEL) {
                    alertReject.close();
                }
             }
         dialogAlert.close();
         } else if (option.get() == ButtonType.CANCEL) {
        dialogAlert.close();
            } 
         
            
         updateVisuals();
    }
    @FXML
    private void endOfLevel(String showScene){
    Parent root;
    CurrentPlayer.updatePlayer(ply);
    Stage stageTheLabelBelongs = (Stage) btnNextWeek.getScene().getWindow(); 
    stageTheLabelBelongs.setTitle("Business Simulator");
    try {
                root = FXMLLoader.load(getClass().getResource(showScene));
                stageTheLabelBelongs.setScene(new Scene(root));
            } catch (IOException ex) {
                Logger.getLogger(Scene2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }     
}
    private void updateVisuals(){
        
        FinancebarUpdater.set((double)ply.getFinance()/100000); 
         CredibilityUpdater.set((double)ply.getCredibility()/100);
         MotivationUpdater.set((double)ply.getPeople()/100); 
         lblFounds.textProperty().bind(new SimpleIntegerProperty(ply.getFinance()).asString());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ply = CurrentPlayer.ply;
//        System.out.println(CurrentPlayer.ply.getName()==null);
        dialogAlert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.APPLY, ButtonType.CANCEL);
        alertReject = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.CANCEL);
        alertEvent = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.CLOSE);
        CredibilityUpdater = new SimpleDoubleProperty(.5);
        MotivationUpdater = new SimpleDoubleProperty(.5);
       FinancebarUpdater = new SimpleDoubleProperty(.5);
       foundsUpdater = new SimpleIntegerProperty();
       
        /*
        FinancebarUpdater.set((double)ply.getFinance()/100000); 
        pbFinance.progressProperty().bind(FinancebarUpdater);
        CredibilityUpdater.set((double)ply.getCredibility()/100);
        pbCredibility.progressProperty().bind(CredibilityUpdater);
        MotivationUpdater.set((double)ply.getPeople()/100);
        pbMotivation.progressProperty().bind(MotivationUpdater);
*/       if(ply.getName()==null){
            System.out.println("IS NULL");
        }else{
            System.out.println(ply.getName());
        }
        lblnam.setText(ply.getName());
       // dialogH = new SimpleStringProperty();
        foundsUpdater.set(ply.getFinance());
       lblFounds.textProperty().bind(new SimpleIntegerProperty(ply.getFinance()).asString());
        
        //dialogAlert.titleProperty().bind(dialogH);
        lblWeek.textProperty().bind(new SimpleIntegerProperty(52-(ply.getTurns())).asString());
        
     //   DatabaseUtil dbu = new DatabaseUtil();
    //    dbu.derbyDBConnection("jdbc:derby:src/javafxapplication1/resources/DBBSim");
        chartFinancial.setData(CurrentPlayer.istoricF);
        //chartFinancial.categoryGapProperty().set(.5);
        
        
        DialogPane dialogReject = alertReject.getDialogPane();
        dialogReject.getStylesheets().add(getClass().getResource("resources/Alert.css").toExternalForm());
        dialogReject.autosize();
        dialogAccept = dialogAlert.getDialogPane();
        dialogAccept.getStylesheets().add(getClass().getResource("resources/Alert.css").toExternalForm());
        dialogAccept.autosize();
        dialogEvent = alertEvent.getDialogPane();
        dialogEvent.getStylesheets().add(getClass().getResource("resources/Alert.css").toExternalForm());
        dialogEvent.autosize();
        dialogEvent.setPrefSize(300, 250);
        
}

}
