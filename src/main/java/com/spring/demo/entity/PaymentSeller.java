package com.spring.demo.entity;

public class PaymentSeller {

    private Long userID;

    private double amount;

    private Long numOrders;

    public PaymentSeller(Long userID, double amount, Long numOrders) {

        super();
        this.userID = userID;
        this.amount = amount;
        this.numOrders = numOrders;
    }

    public PaymentSeller() {
        super();
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
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
