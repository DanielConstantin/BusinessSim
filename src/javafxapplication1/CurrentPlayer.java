package javafxapplication1;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
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
 static ObservableList<XYChart.Series<Integer, Integer>> istoricF= FXCollections.observableArrayList();
 static ObservableList<XYChart.Series<Integer, Integer>> istoricC= FXCollections.observableArrayList();
 static ObservableList<XYChart.Series<Integer, Integer>> istoricM= FXCollections.observableArrayList();
 static XYChart.Series SeriesF = new Series<>();
 static ObservableList<PlyActions> PlyactionList=FXCollections.observableArrayList();
        
    
static void updatePlayer(Player pl){
    ply=pl;
    istoricF.add(SeriesF);
    ActionHandling.createActionList();
} 

static Player getCurrentPlayer(){
    return ply;
    
}
static void updateIstoricF(ObservableList lst, XYChart.Series<Integer,Integer> serie){
    lst.add(serie);
}

}
