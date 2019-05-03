package javafxapplication1;


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
 static  Player ply;
  
static void updatePlayer(Player pl){
    ply=pl;
} 

static Player getCurrentPlayer(){
    return ply;
}
}
