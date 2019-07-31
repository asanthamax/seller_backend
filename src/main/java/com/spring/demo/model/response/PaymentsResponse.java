package com.spring.demo.model.response;


import org.springframework.data.domain.Page;

import java.util.List;

public class PaymentsResponse {

    private Page<PendingPaymentResponse> pendingPaymentResponses;

    private double totalAmount;

    public Page<PendingPaymentResponse> getPendingPaymentResponses() {
        return pendingPaymentResponses;
    }

    public PaymentsResponse(Page<PendingPaymentResponse> pendingPaymentResponses, double totalAmount, double totalPaid, double payable) {
        this.pendingPaymentResponses = pendingPaymentResponses;
        this.totalAmount = totalAmount;
        this.totalPaid = totalPaid;
        this.totalPayable = payable;
    }

    public PaymentsResponse() {
    }

    public void setPendingPaymentResponses(Page<PendingPaymentResponse> pendingPaymentResponses) {
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
