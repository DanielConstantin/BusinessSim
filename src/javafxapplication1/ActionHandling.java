/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author daniel.constantin
 */
public class ActionHandling {
    static ObservableList<PlyActions> actionList=FXCollections.observableArrayList();

static public void createActionList(){
 PlyActions pa1 = new PlyActions(0, "New Product Development", 20, 20000, 52, 2000, 20, 10, "New Product Development", "The cost of this action is 20,000$, implementation takes 20 weeks and bring 2,000$/week till the end of the level.", false, false); 
 PlyActions pa2 = new PlyActions(1, "Improve Products", 8, 4200, 16, 400, 5, 3, "Improve Products", "This action costs 4,200$, implementation takes 8 weeks and revenue/week is 400$ for 16 weeks after implementation is finalized.", false, false); 
actionList.add(pa1);
actionList.add(pa2);
}

static public boolean applyAction(int actionno){
 if(CurrentPlayer.ply.getFinance()>=actionList.get(actionno).getCost()){
     CurrentPlayer.PlyactionList.add(actionList.get(actionno));
     CurrentPlayer.PlyactionList.get(CurrentPlayer.PlyactionList.size()-1).setIsActive(true);
     CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()-actionList.get(actionno).getCost());
     return true;
 }
 else{
     return false;
 }
}
public static void addWeek(){
    CurrentPlayer.ply.setTurns(CurrentPlayer.ply.getTurns()+1);
    for(int i=0; i<CurrentPlayer.PlyactionList.size();i++){
        if(CurrentPlayer.PlyactionList.get(i).isIsActive()){
            CurrentPlayer.PlyactionList.get(i).setTurnsTake(CurrentPlayer.PlyactionList.get(i).getTurnsTake()-1);
        }
        if(CurrentPlayer.PlyactionList.get(i).getTurnsTake()==0){
            CurrentPlayer.PlyactionList.get(i).setIsActive(false);
        }
        if(CurrentPlayer.PlyactionList.get(i).isIsActive()==true&&CurrentPlayer.PlyactionList.get(i).getRevenueWks()>0){
            if(CurrentPlayer.PlyactionList.get(i).getRevenueWks()==actionList.get(CurrentPlayer.PlyactionList.get(i).getNcrt()).getRevenueWks()){
               CurrentPlayer.PlyactionList.get(i).setIncreaseCredibility(CurrentPlayer.PlyactionList.get(i).);
            }
        }
    }
}

}
