package com.spring.demo.model.request;

public class PaymentsRequest {

    private Long userID;

    private String sellerName;

    private Double amount;

    public PaymentsRequest(Long userID, String sellerName, Double amount, int numberOfOrders) {
        this.userID = userID;
        this.sellerName = sellerName;
        this.amount = amount;
        this.numberOfOrders = numberOfOrders;
    }

    public PaymentsRequest() {
    }

    public Long getUserID() {


        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    private int numberOfOrders;
}
