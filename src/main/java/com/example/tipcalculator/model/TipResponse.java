package com.example.tipcalculator.model;

public class TipResponse {
    private double billAmount;
    private int tipPercentage;
    private double tipAmount;
    private double totalAmount;
    private int numberOfPeople;
    private double amountPerPerson;
    private double tipPerPerson;
    private String currency;
    private boolean wasRoundedUp;

    public TipResponse(double billAmount, int tipPercentage, double tipAmount, double totalAmount) {}

    public TipResponse(double billAmount, int tipPercentage, double tipAmount,
                       double totalAmount, int numberOfPeople, double amountPerPerson,
                       double tipPerPerson, String currency, boolean wasRoundedUp) {
        this.billAmount = billAmount;
        this.tipPercentage = tipPercentage;
        this.tipAmount = tipAmount;
        this.totalAmount = totalAmount;
        this.numberOfPeople = numberOfPeople;
        this.amountPerPerson = amountPerPerson;
        this.tipPerPerson = tipPerPerson;
        this.currency = currency;
        this.wasRoundedUp = wasRoundedUp;
    }

    // Getters and setters
    public double getBillAmount() { return billAmount; }
    public void setBillAmount(double billAmount) { this.billAmount = billAmount; }

    public int getTipPercentage() { return tipPercentage; }
    public void setTipPercentage(int tipPercentage) { this.tipPercentage = tipPercentage; }

    public double getTipAmount() { return tipAmount; }
    public void setTipAmount(double tipAmount) { this.tipAmount = tipAmount; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public int getNumberOfPeople() { return numberOfPeople; }
    public void setNumberOfPeople(int numberOfPeople) { this.numberOfPeople = numberOfPeople; }

    public double getAmountPerPerson() { return amountPerPerson; }
    public void setAmountPerPerson(double amountPerPerson) { this.amountPerPerson = amountPerPerson; }

    public double getTipPerPerson() { return tipPerPerson; }
    public void setTipPerPerson(double tipPerPerson) { this.tipPerPerson = tipPerPerson; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public boolean isWasRoundedUp() { return wasRoundedUp; }
    public void setWasRoundedUp(boolean wasRoundedUp) { this.wasRoundedUp = wasRoundedUp; }

    @Override
    public String toString() {
        return "TipResponse{" +
                "billAmount=" + billAmount +
                ", tipPercentage=" + tipPercentage +
                ", tipAmount=" + tipAmount +
                ", totalAmount=" + totalAmount +
                ", numberOfPeople=" + numberOfPeople +
                ", amountPerPerson=" + amountPerPerson +
                ", tipPerPerson=" + tipPerPerson +
                ", currency='" + currency + '\'' +
                ", wasRoundedUp=" + wasRoundedUp +
                '}';
    }
}