package com.spring.demo.model.response;

import com.spring.demo.entity.ProductVariations;

import java.util.Date;
import java.util.List;

public class OrderSampleResponse {

    private long sampleID;

    private String customerName;

    public OrderSampleResponse(long sampleID, String customerName, Date requestedDate, List<String> products, int orderStatus) {
        this.sampleID = sampleID;
        this.customerName = customerName;
        this.requestedDate = requestedDate;
        this.products = products;
        this.orderStatus = orderStatus;
    }

    public OrderSampleResponse() {
    }

    private Date requestedDate;

    public long getSampleID() {
        return sampleID;
    }

    public void setSampleID(long sampleID) {
        this.sampleID = sampleID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    private List<String> products;

    private int orderStatus;
}
