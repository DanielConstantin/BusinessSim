/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

/**
 *
 * @author Osamu
 */
public class Player {

    public void setName(String name) {
        this.name = name;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void setFinance(int finance) {
        this.finance = finance;
    }

    public void setCredibility(int credibility) {
        this.credibility = credibility;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public int getTurns() {
        return turns;
    }

    public int getFinance() {
        return finance;
    }

    public int getCredibility() {
        return credibility;
    }

    public int getPeople() {
        return people;
    }
    private String name;
    //String compName;
    private String persoana;
    private int turns;
    private int finance;
    private int credibility;
    private int people;
    private int gender;

    public Player(String name, String persoana,  int turns, int finance, int credibility, int people, int gender) {
        this.name = name;
        this.persoana=persoana;
        this.turns = turns;
        this.finance = finance;
        this.credibility = credibility;
        this.people = people;
        this.gender =gender;
    }
 //   public void addWeek(){
 //   this.turns++;
//}

    public String getPersoana() {
        return persoana;
    }

    public void setPersoana(String persoana) {
        this.persoana = persoana;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    
    

}
