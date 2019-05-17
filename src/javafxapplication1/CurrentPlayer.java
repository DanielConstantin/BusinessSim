package javafxapplication1;


import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
//import static DbConn.ActionHandling.actionList;
import javafxapplication1.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel.constantin
 */
class CurrentPlayer {
 static Player ply;
 static  ObservableList<XYChart.Series<Integer, Integer>> istoricF= FXCollections.observableArrayList();
 static  ObservableList<XYChart.Series<Integer, Integer>> istoricC= FXCollections.observableArrayList();
 static ObservableList<XYChart.Series<Integer, Integer>> istoricM= FXCollections.observableArrayList();
 static XYChart.Series SeriesF = new Series<>();
 static List<PlyActions> PlyactionList= new ArrayList<>();
       
   
public static void updatePlayer(Player pl){
    ply=pl;
   //istoricF.add(SeriesF);
  //  ActionHandling.createActionList();
  
} 
 public void setCurrentPlayer(Player Ply){
    this.ply=Ply;
}

public Player getCurrentPlayer(){
    return ply;
    
}
static void updateIstoricF(ObservableList lst, XYChart.Series<Integer,Integer> serie){
    lst.add(serie);
}

}
