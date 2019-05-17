/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafxapplication1.CurrentPlayer;
import javafxapplication1.PlyActions;

/**
 *
 * @author 
 */
public class ActionHandling {
    static int MAX_EVENT;
    static List<PlyActions> actionList=new ArrayList();
    static List<plyEvents> eventList = new ArrayList();
    static  int[] lblenable = new int[20];
    
    
    
static public void createActionList(){
 PlyActions pa1 = new PlyActions(0, "New Product Development", 20, 20000, 2000, 52, 20, 10, "New Product Development", "The cost of this action is 20,000$, implementation takes 20 weeks and bring 2,000$/week till the end of the level. Other benefits: Credibility: +10, Motivation: +10.", false, false, 52,20); 
 PlyActions pa2 = new PlyActions(1, "Improve Products", 8, 4200, 400, 16, 5, 3, "Improve Products", "This action costs 4,200$, implementation takes 8 weeks and revenue/week is 400$ for 16 weeks after implementation is finalized. Other benefits: Credibility: +5, Motivation: +3.", false, false, 16,8); 
 PlyActions pa3 = new PlyActions(2, "Cost Reduction", 12, 6000, 300, 52, 3, 2, "Cost Reduction", "This action costs 6000$, implementation takes 12 weeks and revenue/week is 300$ after implementation is finalized till the end of the level. Other benefits: Credibility: +3, Motivation: +2.", false, false,52,12); 
actionList.add(pa1);
actionList.add(pa2);
actionList.add(pa3);

 PlyActions pa4 = new PlyActions(3, "Teambuilding", 2, 600, 200, 4, 2, 5, "Teambuilding", "This action costs 600$, implementation after one week and revenue is 200$/week for 4 weeks after implementation is finalized. Other benefits: Credibility: +2, Motivation: +5.", false, false,4,2); 
 PlyActions pa5 = new PlyActions(4, "Bonus", 2, 800, 250, 4, 1, 5, "Bonus", "This action costs 800$, implementation takes 2 weeks and revenue/week is 250$ during 4 weeks after implementation is finalized. Other benefits: Credibility: +1, Motivation: +5.", true, false,4,2); 
 PlyActions pa6 = new PlyActions(5, "Trainning", 4, 2600, 400, 8, 5, 8, "Trainning", "This action costs 2,600$, implementation takes 4 weeks and revenue/week is 400$ for 8 weeks after implementation is finalized. Other benefits: Credibility: +5, Motivation: +8.", false, false, 8,4); 
actionList.add(pa4);
actionList.add(pa5);
actionList.add(pa6);

 PlyActions pa7 = new PlyActions(6, "TV Spot", 4, 6000, 2000, 4, 9, 5, "TV Spot", "This action costs 6,000$, implementation takes 4 weeks and revenue/week is 2000$ during 4 weeks after implementation is finalized. Other benefits: Credibility: +9, Motivation: +5.", false, false, 4,4); 
 PlyActions pa8 = new PlyActions(7, "Magazine Insert", 1, 500, 300, 2, 2, 1, "Magazine insert", "This action costs 500$, implementation takes 1 week and revenue/week is 300$ for 2 weeks after implementation is finalized. Other benefits: Credibility: +2, Motivation: +1.", false, false,2,1); 
 PlyActions pa9 = new PlyActions(8, "Change Desing", 4, 3200, 1800, 3, 6, 4, "Change Design", "This action costs 3,200$, implementation takes 4 week and revenue/week is 1800$ for 3 weeks after implementation is finalized. Other benefits: Credibility: +6, Motivation: +4.", false, false,3,4); 
 PlyActions pa10 = new PlyActions(9, "Online", 2, 1000, 1125, 1, 2, 1, "Promote Online", "This action costs 1000$, implementation takes 2 weeks and revenue/week is 1150$  after implementation is finalized. Other benefits: Credibility: +2, Motivation: +1.", false, false, 1,2); 
actionList.add(pa7);
actionList.add(pa8);
actionList.add(pa9);
actionList.add(pa10);

 PlyActions pa11 = new PlyActions(10, "Software", 14, 18000, 800, 27, 8, 14, "Software Implementation", "This action costs 18,000$, implementation takes 14 weeks and revenue/week is 800$ for 30 weeks after implementation is finalized. Other benefits: Credibility: +8, Motivation: +14.", false, false,27,14); 
actionList.add(pa11);
}

static public boolean applyAction(int actionno){
 if( CurrentPlayer.ply.getFinance()>=actionList.get(actionno).getCost()){
     PlyActions pa= actionList.get(actionno);
     pa.setIsActive(true);
     pa.setRevenueWks(pa.getWksMartor());
     pa.setTurnsTake(pa.getTksMartor());
   //  pa.setRevenueWks(pa.getRevenueWks()+1);
     CurrentPlayer.PlyactionList.add(pa);
  //   CurrentPlayer.PlyactionList.get(CurrentPlayer.PlyactionList.size()-1).setIsActive(true);
  //   CurrentPlayer.PlyactionList.get(CurrentPlayer.PlyactionList.size()-1).setRevenueWks(CurrentPlayer.PlyactionList.get(CurrentPlayer.PlyactionList.size()-1).getRevenueWks()+1);
     
  //  lblenable[actionList.get(actionno).getNcrt()]=1;   
     CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()-pa.getCost());
           return true;
     
 }
 else{
     return false;
 }
}


public static void addWeek(){
    CurrentPlayer.ply.setTurns(CurrentPlayer.ply.getTurns()+1);
    

    for(int i=0; i<CurrentPlayer.PlyactionList.size();i++){
       // System.out.println("isActive"+CurrentPlayer.PlyactionList.get(i).isIsActive()+"turns "+CurrentPlayer.PlyactionList.get(i).getTurnsTake());
        if(CurrentPlayer.PlyactionList.get(i).isIsActive()==true){

            CurrentPlayer.PlyactionList.get(i).setTurnsTake(CurrentPlayer.PlyactionList.get(i).getTurnsTake()-1);
            
             if(CurrentPlayer.PlyactionList.get(i).getTurnsTake()==0){

            CurrentPlayer.PlyactionList.get(i).setIsActive(false);
            lblenable[CurrentPlayer.PlyactionList.get(i).getNcrt()]=0;
             }
        }   

        if(CurrentPlayer.PlyactionList.get(i).isIsActive()==false && CurrentPlayer.PlyactionList.get(i).getRevenueWks()>0){
           
           // System.out.println("revenue="+CurrentPlayer.PlyactionList.get(i).getRevenueWks()+" martor="+CurrentPlayer.PlyactionList.get(i).getWksMartor());
            if(CurrentPlayer.PlyactionList.get(i).getRevenueWks()==CurrentPlayer.PlyactionList.get(i).getWksMartor()){
               CurrentPlayer.ply.setPeople(CurrentPlayer.PlyactionList.get(i).getIncreaseMotivation()+CurrentPlayer.ply.getPeople());
               CurrentPlayer.ply.setCredibility(CurrentPlayer.PlyactionList.get(i).getIncreaseCredibility()+CurrentPlayer.ply.getCredibility());              
               CurrentPlayer.PlyactionList.get(i).setRevenueWks(CurrentPlayer.PlyactionList.get(i).getRevenueWks()-1);
               CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()+CurrentPlayer.PlyactionList.get(i).getWeeklyRevenue());
             // lblenable[CurrentPlayer.PlyactionList.get(i).getNcrt()]=0;           
            }else{
               CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()+CurrentPlayer.PlyactionList.get(i).getWeeklyRevenue());
                CurrentPlayer.PlyactionList.get(i).setRevenueWks(CurrentPlayer.PlyactionList.get(i).getRevenueWks()-1);}
               
        }     

    }
     
}
static public void createEvList(){
 plyEvents ev0 = new plyEvents(0, "Clients", false,"You have a quality complain from a customer. Finance: -1000$, Credibility:-20, Motivation: -10.",-1000, -20, -10);
 plyEvents ev1 = new plyEvents(0, "Competitors", false,"Your major competitor implement a TV Spot that afect your sales. Finance: -4000$, Credibility -3, People -5.",-4000, -3, -5);
 plyEvents ev2 = new plyEvents(0, "Competitors", false,"A competitor is succesful with a new product. Finance: -1000$, -10, -10", -1000, -10, -10);
 plyEvents ev3 = new plyEvents(0, "Supplier", true,"The producer lowers the price, but the quality. Finance: 500$, Credibility",+500, -2, -1);
 plyEvents ev4 = new plyEvents(0, "Partenship", true,"Partnership with another company in terms of an event. Finance: +3000$, Credibility: +20, Motivation: +15",+3000, +20, +15);
 plyEvents ev5 = new plyEvents(0, "Free Advertising",true, "A famous person promotes your product at an important gala. Finance: +3000$, Credibility: +40, Motivation: +30", +3000, +40, +30);
 plyEvents ev6 = new plyEvents(0, "Autorities", false,"You got a fine. Finance: -3000$, Credibility: -1, Motivation: -1",-3000, -1, -1);
 plyEvents ev7 = new plyEvents(0, "Products", false,"The sales of the main product dropped down. Finance: -3000, Credibility: -12, Motivation: -30",-3000, -12, -30);
 plyEvents ev8 = new plyEvents(0, "Clients", true,"You win a auction. Finance: +1500$, Credibility: +1, Motivation: +2 ",+1500, +1, +2);
 plyEvents ev9 = new plyEvents(0, "Clients", false,"You lost an auction. Finance: -1500$, Credibility -1, People -2",-1500, -1, -2);
 plyEvents ev10= new plyEvents(0, "Authorities",false,"After an investigation you have to pay because you forgot to pay some bills. Finance: -2000$, Credibility -1, People -2",-2000,-1,-2);
 plyEvents ev11= new plyEvents(0, "Products",true,"A famous magazine has chosen you to be the most innovative in terms of products. Finance: +100$, Credibility +30, People +15",+100,+30,+15);
 plyEvents ev12= new plyEvents(0, "Human Error",false,"You've lost some papers, you have to make new ones. Finance: -1500$, Credibility -0, People -2",-1500,-0,-2);
 plyEvents ev13= new plyEvents(0, "Clients",false,"Boicot alert!!! You tested one of your products on animals. Finance: -600$, Credibility -40, People -10",-600,-40,-10);
 plyEvents ev14= new plyEvents(0, "Clients",false,"Considering delivery delays, one of the retailers delisted your products. Finance: -3000$, Credibility: -15, Motivation: -5.",-3000,-15,-5);
 plyEvents ev15= new plyEvents(0, "Autorities",false,"You paid your taxes late, therefore athe authorities sanctioned you. Finance: -1500$, Credibility -1, People -2",-1500,-1,-2);
 plyEvents ev16= new plyEvents(0, "Human Error",false,"One of your employees has wrongly calculated the sale prices, making you lose a contract. Finance: -2000$, Credibility: -8, Motivation:-5.",-2000,-8,-5);
 plyEvents ev17= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev18= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev19= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev20= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev21= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev22= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev23= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev24= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev25= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev26= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev27= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev28= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev29= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev30= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev31= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev32= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev33= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev34= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev35= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev36= new plyEvents(0, "", true, "", +1, +1, +1);
 plyEvents ev37= new plyEvents(0, "", true, "", +1, +1, +1);
 eventList.add(ev0);
 eventList.add(ev1); 
 eventList.add(ev2);
 eventList.add(ev3);
 eventList.add(ev4);
 eventList.add(ev5); 
 eventList.add(ev6);
 eventList.add(ev7);
 eventList.add(ev8);
 eventList.add(ev9);
 
MAX_EVENT = eventList.size()-1;
}


}
 
