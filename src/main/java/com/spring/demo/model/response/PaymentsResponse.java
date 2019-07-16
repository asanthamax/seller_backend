package com.spring.demo.model.response;


import java.util.List;

public class PaymentsResponse {

    private List<PendingPaymentResponse> pendingPaymentResponses;

    private double totalAmount;

    public List<PendingPaymentResponse> getPendingPaymentResponses() {
        return pendingPaymentResponses;
    }

    public PaymentsResponse(List<PendingPaymentResponse> pendingPaymentResponses, double totalAmount, double totalPaid, double payable) {
        this.pendingPaymentResponses = pendingPaymentResponses;
        this.totalAmount = totalAmount;
        this.totalPaid = totalPaid;
        this.totalPayable = payable;
    }

    public PaymentsResponse() {
    }

    public void setPendingPaymentResponses(List<PendingPaymentResponse> pendingPaymentResponses) {
        this.pendingPaymentResponses = pendingPaymentResponses;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public double getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(double totalPayable) {
        this.totalPayable = totalPayable;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;

    }

    private double totalPaid;

    private double totalPayable;
}
