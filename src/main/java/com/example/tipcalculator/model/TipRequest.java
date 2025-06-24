package com.example.tipcalculator.model;

public class TipRequest {
    private Double billAmount;
    private Integer tipPercentage;
    private Integer numberOfPeople = 1; // Новое поле для количества людей
    private Boolean roundUp = false; // Округление вверх
    private String currency = "RUB"; // Валюта

    public TipRequest() {}

    public TipRequest(Double billAmount, Integer tipPercentage, Integer numberOfPeople) {
        this.billAmount = billAmount;
        this.tipPercentage = tipPercentage;
        this.numberOfPeople = numberOfPeople;
    }

    // Getters and setters
    public Double getBillAmount() { return billAmount; }
    public void setBillAmount(Double billAmount) { this.billAmount = billAmount; }

    public Integer getTipPercentage() { return tipPercentage; }
    public void setTipPercentage(Integer tipPercentage) { this.tipPercentage = tipPercentage; }

    public Integer getNumberOfPeople() { return numberOfPeople; }
    public void setNumberOfPeople(Integer numberOfPeople) { this.numberOfPeople = numberOfPeople; }

    public Boolean getRoundUp() { return roundUp; }
    public void setRoundUp(Boolean roundUp) { this.roundUp = roundUp; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    @Override
    public String toString() {
        return "TipRequest{" +
                "billAmount=" + billAmount +
                ", tipPercentage=" + tipPercentage +
                ", numberOfPeople=" + numberOfPeople +
                ", roundUp=" + roundUp +
                ", currency='" + currency + '\'' +
                '}';
    }
}