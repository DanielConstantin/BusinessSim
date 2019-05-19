/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Osamu
 */
public class ActionHandling {
    static int MAX_EVENT;
    static List<PlyActions> actionList=new ArrayList();
    static List<plyEvents> eventList = new ArrayList();
    static  int[] lblenable = new int[20];
    
    
    
static public void createActionList(){
 PlyActions pa1 = new PlyActions(0, "New Product Development", 20, 20000, 2000, 52, 20, 10, "New Product Development", "The cost of this action is 20,000$, implementation takes 20 weeks and bring 2,000$/week till the end of the level. Other benefits: Credibility: +10, Motivation: +10.", false, false, 52,20); 
 PlyActions pa2 = new PlyActions(1, "Improve Products", 8, 4200, 400, 16, 5, 3, "Improve Products", "This action costs 4,200$, implementation takes 8 weeks and revenue/week is 400$ for 16 weeks after implementation is finalized. Other benefits: Credibility: +5, Motivation: +3.", false, false, 16,8); 
 PlyActions pa3 = new PlyActions(2, "Cost Reduction", 12, 6000, 300, 52, 3, 2, "Cost Reduction", "This action costs 6000$, implementation takes 12 weeks and revenue/week is 300$ after implementation is finalized till the end of the level. Other benefits: Credibility:+3, Motivation:+2.", false, false,52,12); 
actionList.add(pa1);
actionList.add(pa2);
actionList.add(pa3);

 PlyActions pa4 = new PlyActions(3, "Teambuilding", 2, 600, 200, 4, 2, 5, "Teambuilding", "This action costs 600$, implementation after one week and revenue is 200$/week for 4 weeks after implementation is finalized. Other benefits: Credibility: +2, Motivation: +5.", false, false,4,2); 
 PlyActions pa5 = new PlyActions(4, "Bonus", 2, 800, 250, 4, 1, 5, "Bonus", "This action costs 800$, implementation takes 2 weeks and revenue/week is 250$ during 4 weeks after implementation is finalized. Other benefits: Credibility: +1, Motivation: +5.", true, false,4,2); 
 PlyActions pa6 = new PlyActions(5, "Training", 4, 2600, 400, 8, 5, 8, "Training", "This action costs 2,600$, implementation takes 4 weeks and revenue/week is 400$ for 8 weeks after implementation is finalized. Other benefits: Credibility:+5, Motivation:+8.", false, false, 8,4); 
actionList.add(pa4);
actionList.add(pa5);
actionList.add(pa6);

 PlyActions pa7 = new PlyActions(6, "TV Spot", 4, 6000, 2000, 4, 9, 5, "TV Spot", "This action costs 6,000$, implementation takes 4 weeks and revenue/week is 2000$ during 4 weeks after implementation is finalized. Other benefits: Credibility: +9, Motivation: +5.", false, false, 4,4); 
 PlyActions pa8 = new PlyActions(7, "Magazine Insert", 1, 500, 300, 2, 2, 1, "Magazine insert", "This action costs 500$, implementation takes 1 week and revenue/week is 300$ for 2 weeks after implementation is finalized. Other benefits: Credibility: +2, Motivation: +1.", false, false,2,1); 
 PlyActions pa9 = new PlyActions(8, "Change Desing", 4, 3200, 1800, 3, 6, 4, "Change Design", "This action costs 3,200$, implementation takes 4 week and revenue/week is 1800$ for 3 weeks after implementation is finalized. Other benefits: Credibility: +6, Motivation:+4.", false, false,3,4); 
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
     
    lblenable[actionList.get(actionno).getNcrt()]=1;   
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
 plyEvents ev0 = new plyEvents(0, "Clients", false,"You have a quality complain from a customer. Finance: -1000$, Credibility:-8, Motivation: -2.",-1000, -8, -2);
 plyEvents ev1 = new plyEvents(0, "Competitors", false,"Your major competitor implemented a TV Spot that afect your sales. Finance: -4000$, Credibility: -3, Motivation: -9.",-4000, -3, -9);
 plyEvents ev2 = new plyEvents(0, "Competitors", false,"A competitor is succesful with a new product. Finance: -1000$, -5, -3", -1000, -5, -3);
 plyEvents ev3 = new plyEvents(0, "Supplier", true,"The producer lowers the price, but the quality of service decreases. Finance: 500$, Credibility:-2, Motivation:-1.",+500, -2, -1);
 plyEvents ev4 = new plyEvents(0, "Partnership", true,"Partnership with another company in terms of an event. Finance: +3000$, Credibility: +7, Motivation: +6.",+3000, +7, +6);
 plyEvents ev5 = new plyEvents(0, "Free Advertising",true, "A famous person promotes your product at an important gala. Finance: +1000$, Credibility: +4, Motivation: +3.", +1000, +4, +3);
 plyEvents ev6 = new plyEvents(0, "Autorities", false,"You got a fine. Finance: -3000$, Credibility: -1, Motivation: -1.",-3000, -1, -1);
 plyEvents ev7 = new plyEvents(0, "Products", false,"The sales of the main product dropped down. Finance: -3000, Credibility: -5, Motivation: -13.",-3000, -5, -13);
 plyEvents ev8 = new plyEvents(0, "Clients", true,"You win an auction. Finance: +1500$, Credibility: +1, Motivation: +2.",+1500, +1, +2);
 plyEvents ev9 = new plyEvents(0, "Clients", false,"You lost an auction. Finance: -1500$, Credibility -1, Motivation: -2.",-1500, -1, -2);
 plyEvents ev10= new plyEvents(0, "Authorities",false,"After an investigation  you have to pay penalties because you miscalculate some taxes. Finance: -3000$, Credibility: -5, Motivation: -5.",-3000,-5,-5);
 plyEvents ev11= new plyEvents(0, "Products",true,"A famous magazine has chosen you to be the most innovative in terms of products. Finance: +100$, Credibility: +5, Motivation: +3.",+100,+5,+3);
 plyEvents ev12= new plyEvents(0, "Human Error",false,"You've lost some accounting papers, you have to make new ones. Finance: -1500$, Credibility: -0, Motivation: -2.",-1500,0,-2);
 plyEvents ev13= new plyEvents(0, "Clients",false,"Boicot alert!!! You tested one of your products on animals. Finance: -600$, Credibility: -4, Motivation: -1.",-600,-4,-1);
 plyEvents ev14= new plyEvents(0, "Clients",false,"Considering delivery delays, one of the retailers delisted your products. Finance: -3000$, Credibility: -5, Motivation: -5.",-3000,-5,-5);
 plyEvents ev15= new plyEvents(0, "Autorities",false,"You paid your taxes late, therefore the authorities fined you. Finance: -1500$, Credibility: -1, Motivation: -2.",-1500,-1,-2);
 plyEvents ev16= new plyEvents(0, "Human Error",false,"One of your employees has wrongly calculated the sale prices, making you lose a contract. Finance: -2000$, Credibility: -8, Motivation:-5.",-2000,-8,-5);
 plyEvents ev17= new plyEvents(0, "Clients", false, "One of your servers crushed. You need to replace it and restore the data, that caused some chaos in your deliveries. Finance: -1000$, Credibility: -3, Motivation: -2", -1000, -3, -2);
 plyEvents ev18= new plyEvents(0, "Clients", true, "You made a good job with your last delivery. Your clients are excited about your work. Finance: +2000$, Credibility: +6, Motivation: +5.", +2000, +6, +5);
 plyEvents ev19= new plyEvents(0, "Employees", true, "Your employees have done a good work this week. Finance: +800$, Credibility +3, Motivation: +4.", +800, +3, +4);
 plyEvents ev20= new plyEvents(0, "Products", true, "Some investors are attracted to your products, you begun  some collaborations  that will benefit you. Finance: +2000, Credibility: +3, Motivation:+4.", +2000, +3, +4);
 plyEvents ev21= new plyEvents(0, "Free Advertising", true, "Some sponsors have offered to pay you money for a TV commercial. Finance: +900$, Credibility: +2, Motivation: +1.", +900, +2, +1);
 plyEvents ev22= new plyEvents(0, "Free Advertising", true, "Some sponsors have offered to pay you money for a radio commercial. Finance: +300$, Credibility: +5, Motivation: +2.", +300, +5, +2);
 plyEvents ev23= new plyEvents(0, "Lucky", true, "You received the new equipment as a gift. Credibility: +3, Motivation: +4.", +0, +3, +4);
 plyEvents ev24= new plyEvents(0, "Employees", true, "Your business accountant is becoming more and more skillful. Finance: +1000$, Credibility +1, Motivation: +4.", +1000, +1, +4);
 plyEvents ev25= new plyEvents(0, "Lucky", true, "Netflex has given you an opportunity to develop a project together. Finance: +2000$, Credibility: +10, Motivation: +5.", +2000, +10, +5);
 plyEvents ev26= new plyEvents(0, "Free Advertising", true, "A documentary about your business has been made. Finance: +1500$, Credibility: +3, Motivation: +4.", +1500, +3, +4);
 plyEvents ev27= new plyEvents(0, "Free Advertising", true, "Micky Ninaj tweeted and said she likes your products. Finance: +3000$, Credibility: +2, Motivation: +4.", +3000, +2, +4);
 plyEvents ev28= new plyEvents(0, "Clients", false, "Micky Ninaj tweeted and said she doen't like your products. Finance: -3000$, Credibility: -2, Motivation: -4.", -3000, -2, -4);
 plyEvents ev29= new plyEvents(0, "Free Advertising", true, "Gelena Somez tweeted and said she likes your products. Finance: +2000$, Credibility: +8, Motivation: +4.", +2000, +8, +4);
 plyEvents ev30= new plyEvents(0, "Clients", false, "A TV news mentions one of your products in a bad context, your sales droped. Finance: -3000$, Credibility: -6, Motivation: -5.", -3000, -6, -5);
 plyEvents ev31= new plyEvents(0, "Free Advertising", true, "Cim Cardashian posted on Biztagram and said she likes your products. Finance: +4000$, Credibility: +2, Motivation: +4.", +4000, +2, +4);
 plyEvents ev32= new plyEvents(0, "Clients", false, "Cim Cardashian posted on Biztagram and said she doen't like your products. Finance: -4000$, Credibility: -2, Motivation: -4.", -4000, -2, -4);
 plyEvents ev33= new plyEvents(0, "Free Advertising", true, "PewPieDie posted on BizTube and said he likes your products. Finance: +4000$, Credibility: +2, Motivation: +4.", +4000, +2, +4);
 plyEvents ev34= new plyEvents(0, "Clients", false, "PewPieDie posted on Biztube and said he doen't like your products. Finance: -4000$, Credibility: -2, Motivation: -4.", -4000, -2, -4);
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
  eventList.add(ev10);
 eventList.add(ev11); 
 eventList.add(ev12);
 eventList.add(ev13);
 eventList.add(ev14);
 eventList.add(ev15); 
 eventList.add(ev16);
 eventList.add(ev17);
 eventList.add(ev18);
 eventList.add(ev19);
 eventList.add(ev20);
 eventList.add(ev21); 
 eventList.add(ev22);
 eventList.add(ev23);
 eventList.add(ev24);
 eventList.add(ev25); 
 eventList.add(ev26);
 eventList.add(ev27);
 eventList.add(ev28);
 eventList.add(ev29); 
 eventList.add(ev30); 
 eventList.add(ev31);
 eventList.add(ev32);
 eventList.add(ev33);
 eventList.add(ev34);
MAX_EVENT = eventList.size()-1;
}


}
 
