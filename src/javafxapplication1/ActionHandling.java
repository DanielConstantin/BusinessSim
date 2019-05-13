/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafxapplication1.CurrentPlayer;
import javafxapplication1.PlyActions;

/**
 *
 * @author daniel.constantin
 */
public class ActionHandling {
    static ObservableList<PlyActions> actionList=FXCollections.observableArrayList();
    static  int[] lblenable = new int[20];
static public void createActionList(){
 PlyActions pa1 = new PlyActions(0, "New Product Development", 20, 20000, 52, 2000, 20, 10, "New Product Development", "The cost of this action is 20,000$, implementation takes 20 weeks and bring 2,000$/week till the end of the level. Other benefits: Credibility: +10, Motivation: +10.", false, true); 
 PlyActions pa2 = new PlyActions(1, "Improve Products", 8, 4200, 16, 400, 5, 3, "Improve Products", "This action costs 4,200$, implementation takes 8 weeks and revenue/week is 400$ for 16 weeks after implementation is finalized. Other benefits: Credibility: +5, Motivation: +3.", false, true); 
 PlyActions pa3 = new PlyActions(2, "Cost Reduction", 12, 6000, 52, 300, 3, 2, "Cost Reduction", "This action costs 6000$, implementation takes 12 weeks and revenue/week is 300$ after implementation is finalized till the end of the level. Other benefits: Credibility: +3, Motivation: +2.", false, true); 
actionList.add(pa1);
actionList.add(pa2);
actionList.add(pa3);

 PlyActions pa4 = new PlyActions(3, "Teambuilding", 2, 600, 4, 200, 2, 5, "Teambuilding", "This action costs 600$, implementation after one week and revenue is 200$/week for 4 weeks after implementation is finalized. Other benefits: Credibility: +2, Motivation: +5.", false, true); 
 PlyActions pa5 = new PlyActions(4, "Bonus", 2, 800, 4, 250, 1, 5, "Bonus", "This action costs 800$, implementation takes 2 weeks and revenue/week is 250$ during 4 weeks after implementation is finalized. Other benefits: Credibility: +1, Motivation: +5.", true, true); 
 PlyActions pa6 = new PlyActions(5, "Trainning", 4, 2600, 8, 400, 5, 8, "Trainning", "This action costs 2,600$, implementation takes 4 weeks and revenue/week is 400$ for 8 weeks after implementation is finalized. Other benefits: Credibility: +5, Motivation: +8.", false, true); 
actionList.add(pa4);
actionList.add(pa5);
actionList.add(pa6);

 PlyActions pa7 = new PlyActions(6, "TV Spot", 4, 6000, 4, 2000, 9, 5, "TV Spot", "This action costs 6,000$, implementation takes 4 weeks and revenue/week is 2000$ during 4 weeks after implementation is finalized. Other benefits: Credibility: +9, Motivation: +5.", false, true); 
 PlyActions pa8 = new PlyActions(7, "Magazine Insert", 1, 500, 2, 300, 2, 1, "Magazine insert", "This action costs 500$, implementation takes 1 week and revenue/week is 300$ for 2 weeks after implementation is finalized. Other benefits: Credibility: +2, Motivation: +1.", false, true); 
 PlyActions pa9 = new PlyActions(8, "Change Desing", 4, 3200, 3, 1800, 6, 4, "Change Design", "This action costs 3,200$, implementation takes 4 week and revenue/week is 1800$ for 3 weeks after implementation is finalized. Other benefits: Credibility: +6, Motivation: +4.", false, true); 
 PlyActions pa10 = new PlyActions(9, "Online", 2, 1000, 1, 575, 2, 1, "Promote Online", "This action costs 1000$, implementation takes 2 weeks and revenue/week is 1150$  after implementation is finalized. Other benefits: Credibility: +2, Motivation: +1.", false, true); 
actionList.add(pa7);
actionList.add(pa8);
actionList.add(pa9);
actionList.add(pa10);

 PlyActions pa11 = new PlyActions(10, "Software", 14, 18000, 27, 800, 8, 14, "Software Implementation", "This action costs 18,000$, implementation takes 14 weeks and revenue/week is 800$ for 30 weeks after implementation is finalized. Other benefits: Credibility: +8, Motivation: +14.", false, true); 
actionList.add(pa11);
}

static public boolean applyAction(int actionno){
 if(CurrentPlayer.ply.getFinance()>=actionList.get(actionno).getCost()){
     CurrentPlayer.PlyactionList.add(actionList.get(actionno));
     CurrentPlayer.PlyactionList.get(CurrentPlayer.PlyactionList.size()-1).setIsActive(true);
     lblenable[actionList.get(actionno).getNcrt()]=1;
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
            
             if(CurrentPlayer.PlyactionList.get(i).getTurnsTake()==0){

            CurrentPlayer.PlyactionList.get(i).setIsActive(false);
        }
        }   

        if(CurrentPlayer.PlyactionList.get(i).isIsActive()==false && CurrentPlayer.PlyactionList.get(i).getRevenueWks()>0){

            if(CurrentPlayer.PlyactionList.get(i).getRevenueWks()==actionList.get(CurrentPlayer.PlyactionList.get(i).getNcrt()).getRevenueWks()){

               CurrentPlayer.ply.setPeople(CurrentPlayer.PlyactionList.get(i).getIncreaseMotivation()+CurrentPlayer.ply.getPeople());
               CurrentPlayer.ply.setPeople(CurrentPlayer.PlyactionList.get(i).getIncreaseMotivation()+CurrentPlayer.ply.getPeople());
              lblenable[CurrentPlayer.PlyactionList.get(i).getNcrt()]=0;
            }
               CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()+CurrentPlayer.PlyactionList.get(i).getRevenueWks());
        }

    }
}

}
