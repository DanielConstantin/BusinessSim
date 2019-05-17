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
 * @author 
 */
public class Scene2Controller implements Initializable {
    private static Player ply;
    StringProperty dialogH;
    static int actionNo;
    
    Alert dialogAlert;
    Alert alertReject;
    Alert alertEvent;
    
    
    @FXML
    private ProgressBar pbCredibility;
    private  DoubleProperty CredibilityUpdater = new SimpleDoubleProperty(.5);
    @FXML
    private ProgressBar pbMotivation;
     private DoubleProperty MotivationUpdater = new SimpleDoubleProperty(.5);
    @FXML
    private Label lblFounds;
    private final IntegerProperty foundsUpdater=new SimpleIntegerProperty();
    @FXML
    private Label lblnam11;
   // Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private ProgressBar pbFinance;
    private final DoubleProperty FinancebarUpdater=new SimpleDoubleProperty();
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
    public final IntegerProperty credibilityUpdater= new SimpleIntegerProperty();   
    @FXML
    private Label lblfinprc;
    
    @FXML
    private Label lblmotivprc;
    public final IntegerProperty motivationUpdater=new SimpleIntegerProperty(); 
    
 

    
 
 //   @FXML
//    private Label lblnam1;

    
     
    @FXML
    private void OnMouseClicked(MouseEvent e) {
         
        CurrentPlayer.updatePlayer(ply);
        if (e.getSource() == btnNextWeek) {
            
            
            if (ply.getTurns() == 52 || ply.getFinance()<=0 || 0 >=ply.getCredibility() || 0>=ply.getPeople()) {
                if (ply.getFinance() < 100000) {
                    endOfLevel("GameOver.fxml");
                } else {
                    endOfLevel("LevelComplete.fxml");
                }
            }
            ActionHandling.addWeek();
            ply = CurrentPlayer.ply;
            lblWeek.textProperty().bind(new SimpleIntegerProperty(52-(ply.getTurns())).asString());
            lblFounds.textProperty().bind(foundsUpdater.asString());
            
            CurrentPlayer.SeriesF.getData().add(new XYChart.Data<>(Integer.toString(ply.getTurns()),Integer.valueOf(ply.getFinance())));
            updateVisuals();
           CurrentPlayer.updatePlayer(ply);
           for(int m=0; m<ActionHandling.lblenable.length;m++){
           
               switch(m){
                   case 0: if(ActionHandling.lblenable[m]==0) {lblNewP.setDisable(false);}else {lblNewP.setDisable(true);continue;}
                   case 1: if(ActionHandling.lblenable[m]==0) {lblImproveP.setDisable(false);}else {lblImproveP.setDisable(true);continue;}
                   case 2: if(ActionHandling.lblenable[m]==0) {lblCostR.setDisable(false);}else {lblCostR.setDisable(true);continue;}
                   case 3: if(ActionHandling.lblenable[m]==0) {lblTeamB.setDisable(false);}else {lblTeamB.setDisable(true);continue;}
                   case 4: if(ActionHandling.lblenable[m]==0) {lblBonus.setDisable(false);}else {lblBonus.setDisable(true);continue;}
                   case 5: if(ActionHandling.lblenable[m]==0) {lblTrainning.setDisable(false);}else {lblTrainning.setDisable(true);continue;}
                   case 6: if(ActionHandling.lblenable[m]==0) {lblTVSpot.setDisable(false);}else {lblTVSpot.setDisable(true);continue;}
                   case 7: if(ActionHandling.lblenable[m]==0) {lblMInsert.setDisable(false);}else {lblMInsert.setDisable(true);continue;}
                   case 8: if(ActionHandling.lblenable[m]==0) {lblChangeD.setDisable(false);}else {lblChangeD.setDisable(true);continue;}
                   case 9: if(ActionHandling.lblenable[m]==0) {lblOnline.setDisable(false);}else {lblOnline.setDisable(true);continue;}
                   case 10:if(ActionHandling.lblenable[m]==0) {lblSoftware.setDisable(false);}else {lblSoftware.setDisable(true);continue;}
                   default: 
 
               }
           }
           
           implementEvent();
          
           
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
       //  updateVisuals();
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
    private void implementEvent(){
        int chooseEv =(int)(Math.random()*ActionHandling.MAX_EVENT)+(ActionHandling.MAX_EVENT/4);
           System.out.println("chooseEv="+chooseEv);
           if(ply.getTurns()>1 && (ActionHandling.MAX_EVENT)>=chooseEv){
           
           alertEvent.setHeaderText(ActionHandling.eventList.get(chooseEv).getEvName());     
           alertEvent.setContentText(ActionHandling.eventList.get(chooseEv).getEvMessage());
           Optional<ButtonType> optionn = alertEvent.showAndWait();         
          
             if (optionn.get() == ButtonType.CLOSE) {
  
                 ply.setFinance(ActionHandling.eventList.get(chooseEv).getEvFinancial()+ply.getFinance());
                 ply.setCredibility(ActionHandling.eventList.get(chooseEv).getEvCredibility()+ply.getCredibility());
                 ply.setPeople(ActionHandling.eventList.get(chooseEv).getEvMotivation()+ply.getPeople());
                 CurrentPlayer.updatePlayer(ply);
                 updateVisuals();
                 alertEvent.close();
             
            }
       
    
            updateVisuals();
           }
    }
    private void updateVisuals(){
        lblWeek.textProperty().bind(new SimpleIntegerProperty(52-(ply.getTurns())).asString());
        FinancebarUpdater.set((double)ply.getFinance()/100000); 
        
         MotivationUpdater.set((double)ply.getPeople()/100); 
        lblFounds.textProperty().bind(new SimpleIntegerProperty(ply.getFinance()).asString());
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ply = CurrentPlayer.ply;
        dialogAlert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.APPLY, ButtonType.CANCEL);
        alertReject = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.CANCEL);
        alertEvent = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.CLOSE);
     //   CredibilityUpdater = new SimpleDoubleProperty();
   //     MotivationUpdater = new SimpleDoubleProperty();
    //    FinancebarUpdater = new SimpleDoubleProperty();
    //    foundsUpdater = new SimpleIntegerProperty();
    //    credibilityUpdater = new SimpleIntegerProperty();
    //    motivationUpdater = new SimpleIntegerProperty();
      
        FinancebarUpdater.set((double)ply.getFinance()/100000); 
        pbFinance.progressProperty().bind(FinancebarUpdater);
    
        
    //    CredibilityUpdater.set(((double)ply.getCredibility()/100));
    //    pbCredibility.progressProperty().add(CredibilityUpdater);
        
        
        
        MotivationUpdater.set((double)ply.getPeople()/100);
        pbMotivation.progressProperty().bind(MotivationUpdater);    
       
        lblnam.setText(ply.getName());
       // dialogH = new SimpleStringProperty();
        foundsUpdater.set(ply.getFinance());
    //    credibilityUpdater.set(ply.getCredibility());
    //    motivationUpdater.set(ply.getPeople());
       
       lblFounds.textProperty().bind(new SimpleIntegerProperty(ply.getFinance()).asString());
       lblmotivprc.textProperty().bind(new SimpleIntegerProperty(ply.getPeople()).asString());
       lblcredibilprc.textProperty().bind(new SimpleIntegerProperty(ply.getCredibility()).asString());
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
