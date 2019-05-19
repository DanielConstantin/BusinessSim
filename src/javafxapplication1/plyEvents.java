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
public class plyEvents {
    private int nrcrt;
    private String evName;
    private boolean positive;
    private String evMessage;
    private int evFinancial;
    private int evCredibility;
    private int evMotivation;

    public plyEvents(int nrcrt, String evName, boolean positive, String evMessage, int evFinancial, int evCredibility, int evMotivation) {
        this.nrcrt = nrcrt;
        this.evName = evName;
        this.positive = positive;
        this.evMessage = evMessage;
        this.evFinancial = evFinancial;
        this.evCredibility = evCredibility;
        this.evMotivation = evMotivation;
    }

    public int getEvMotivation() {
        return evMotivation;
    }

    public void setEvMotivation(int evMotivation) {
        this.evMotivation = evMotivation;
    }

    public int getNrcrt() {
        return nrcrt;
    }

    public void setNrcrt(int nrcrt) {
        this.nrcrt = nrcrt;
    }

    public String getEvName() {
        return evName;
    }

    public void setEvName(String evName) {
        this.evName = evName;
    }

    

    public String getEvMessage() {
        return evMessage;
    }

    public void setEvMessage(String evMessage) {
        this.evMessage = evMessage;
    }

    public int getEvFinancial() {
        return evFinancial;
    }

    public void setEvFinancial(int evFinancial) {
        this.evFinancial = evFinancial;
    }

    public int getEvCredibility() {
        return evCredibility;
    }

    public void setEvCredibility(int evCredibility) {
        this.evCredibility = evCredibility;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }
 
  
}
