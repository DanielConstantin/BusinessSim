package javafxapplication1;


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
 static ObservableList<PlyActions> PlyactionList=FXCollections.observableArrayList();
        
   
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
/*
public static void addWeek(){
    CurrentPlayer.ply.setTurns(CurrentPlayer.ply.getTurns()+1);
    for(int i=0; i<CurrentPlayer.PlyactionList.size();i++){
        if(CurrentPlayer.PlyactionList.get(i).isIsActive()==true){
            CurrentPlayer.PlyactionList.get(i).setTurnsTake(CurrentPlayer.PlyactionList.get(i).getTurnsTake()-1);
        }
        if(CurrentPlayer.PlyactionList.get(i).getTurnsTake()==0){
            CurrentPlayer.PlyactionList.get(i).setIsActive(false);
        }
        if(CurrentPlayer.PlyactionList.get(i).isIsActive()==true && CurrentPlayer.PlyactionList.get(i).getRevenueWks()>0){
            if(CurrentPlayer.PlyactionList.get(i).getRevenueWks()==actionList.get(CurrentPlayer.PlyactionList.get(i).getNcrt()).getRevenueWks()){              
               CurrentPlayer.ply.setCredibility(CurrentPlayer.PlyactionList.get(i).getIncreaseCredibility()+CurrentPlayer.ply.getCredibility());
               CurrentPlayer.ply.setPeople(CurrentPlayer.PlyactionList.get(i).getIncreaseMotivation()+CurrentPlayer.ply.getPeople());
            }
            CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()+CurrentPlayer.PlyactionList.get(i).getRevenueWks());
        }
    }
}*/
}
