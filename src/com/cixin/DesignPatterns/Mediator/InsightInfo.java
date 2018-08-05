package com.cixin.DesignPatterns.Mediator;

public class InsightInfo {
    private Double spent;
    private Integer reach;
    private Integer clicks;
    private Integer impression;

    InsightInfo(Double spent, Integer reach, Integer clicks, Integer impression) {
        this.spent = spent;this.reach =  reach;this.clicks = clicks;this.impression = impression;
    }

    public double getSpent() {
        return spent;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getImpression() {
        return impression;
    }

    public void setImpression(int impression) {
        this.impression = impression;
    }
}
