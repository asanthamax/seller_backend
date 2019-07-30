package com.spring.demo.entity;

public class PaymentSeller {

    private Seller userID;

    private double amount;

    private Long numOrders;

    public PaymentSeller(Seller userID, double amount, Long numOrders) {
        this.userID = userID;
        this.amount = amount;
        this.numOrders = numOrders;
    }

    public PaymentSeller() {
    }

    public Seller getUserID() {
        return userID;
    }

    public void setUserID(Seller userID) {
        this.userID = userID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getNumOrders() {
        return numOrders;
    }

    public void setNumOrders(Long numOrders) {
        this.numOrders = numOrders;
    }
}
