/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.collections.ObservableList;

/**
 *
 * @author daniel.constantin
 */
public class PlyActions {
    private int ncrt;
    private String actionName;
    private int turnsTake;
    private int cost;
    private int weeklyRevenue;
    private int revenueWks;
    private int increaseCredibility;
    private int increaseMotivation;
    private String messageHeader;
    private String messageBody;
    private boolean multiple;
    private boolean isActive;

    public PlyActions(int ncrt, String actionName, int turnsTake, int cost, int weeklyRevenue, int revenueWks, int increaseCredibility, int increaseMotivation, String messageHeader, String messageBody, boolean multiple, boolean isActive) {
        this.ncrt = ncrt;
        this.actionName = actionName;
        this.turnsTake = turnsTake;
        this.cost = cost;
        this.weeklyRevenue = weeklyRevenue;
        this.revenueWks = revenueWks;
        this.increaseCredibility = increaseCredibility;
        this.increaseMotivation = increaseMotivation;
        this.messageHeader = messageHeader;
        this.messageBody = messageBody;
        this.multiple = multiple;
        this.isActive = isActive;
    }
 
    

    public int getNcrt() {
        return ncrt;
    }

    public void setNcrt(int ncrt) {
        this.ncrt = ncrt;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public int getTurnsTake() {
        return turnsTake;
    }

    public void setTurnsTake(int turnsTake) {
        this.turnsTake = turnsTake;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeeklyRevenue() {
        return weeklyRevenue;
    }

    public void setWeeklyRevenue(int weeklyRevenue) {
        this.weeklyRevenue = weeklyRevenue;
    }

    public int getRevenueWks() {
        return revenueWks;
    }

    public void setRevenueWks(int revenueWks) {
        this.revenueWks = revenueWks;
    }

    public int getIncreaseCredibility() {
        return increaseCredibility;
    }

    public void setIncreaseCredibility(int increaseCredibility) {
        this.increaseCredibility = increaseCredibility;
    }

    public int getIncreaseMotivation() {
        return increaseMotivation;
    }

    public void setIncreaseMotivation(int increaseMotivation) {
        this.increaseMotivation = increaseMotivation;
    }

    public String getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(String messageHeader) {
        this.messageHeader = messageHeader;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
   
}
