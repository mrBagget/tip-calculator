package com.example.tipcalculator.model;

public class TipRequest {
    private Double billAmount;  // Изменено с double на Double
    private Integer tipPercentage;  // Изменено с int на Integer

    public TipRequest() {}

    public TipRequest(Double billAmount, Integer tipPercentage) {
        this.billAmount = billAmount;
        this.tipPercentage = tipPercentage;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Integer getTipPercentage() {
        return tipPercentage;
    }

    public void setTipPercentage(Integer tipPercentage) {
        this.tipPercentage = tipPercentage;
    }

    @Override
    public String toString() {
        return "TipRequest{" +
                "billAmount=" + billAmount +
                ", tipPercentage=" + tipPercentage +
                '}';
    }
}