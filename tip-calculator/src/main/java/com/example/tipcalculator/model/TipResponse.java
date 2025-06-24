package com.example.tipcalculator.model;

public class TipResponse {
    private double billAmount;
    private int tipPercentage;
    private double tipAmount;
    private double totalAmount;

    public TipResponse() {}

    public TipResponse(double billAmount, int tipPercentage, double tipAmount, double totalAmount) {
        this.billAmount = billAmount;
        this.tipPercentage = tipPercentage;
        this.tipAmount = tipAmount;
        this.totalAmount = totalAmount;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public int getTipPercentage() {
        return tipPercentage;
    }

    public void setTipPercentage(int tipPercentage) {
        this.tipPercentage = tipPercentage;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = tipAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "TipResponse{" +
                "billAmount=" + billAmount +
                ", tipPercentage=" + tipPercentage +
                ", tipAmount=" + tipAmount +
                ", totalAmount=" + totalAmount +
                '}';
    }
}