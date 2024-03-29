package com.spring.demo.model.response;

public class PendingPaymentResponse {

    private Long userID;

    private String sellerName;

    private Double amount;

    public PendingPaymentResponse(Long userID, String sellerName, Double amount, Long numberOfOrders) {
        this.userID = userID;
        this.sellerName = sellerName;
        this.amount = amount;
        this.numberOfOrders = numberOfOrders;
    }

    public PendingPaymentResponse() {
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

    public Long getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(Long numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    private Long numberOfOrders;

}
