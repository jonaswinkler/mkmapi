package de.jpwinkler.mkmapi.model;

public class PriceGuide {
    private double SELL;
    private double LOW;
    private double LOWEX;
    private double LOWFOIL;
    private double AVG;
    private double TREND;
    private double TRENDFOIL;

    public double getSELL() {
        return SELL;
    }

    public void setSELL(double SELL) {
        this.SELL = SELL;
    }

    public double getLOW() {
        return LOW;
    }

    public void setLOW(double LOW) {
        this.LOW = LOW;
    }

    public double getLOWEX() {
        return LOWEX;
    }

    public void setLOWEX(double LOWEX) {
        this.LOWEX = LOWEX;
    }

    public double getLOWFOIL() {
        return LOWFOIL;
    }

    public void setLOWFOIL(double LOWFOIL) {
        this.LOWFOIL = LOWFOIL;
    }

    public double getAVG() {
        return AVG;
    }

    public void setAVG(double AVG) {
        this.AVG = AVG;
    }

    public double getTREND() {
        return TREND;
    }

    public void setTREND(double TREND) {
        this.TREND = TREND;
    }

    public double getTRENDFOIL() {
        return TRENDFOIL;
    }

    public void setTRENDFOIL(double TRENDFOIL) {
        this.TRENDFOIL = TRENDFOIL;
    }
}
