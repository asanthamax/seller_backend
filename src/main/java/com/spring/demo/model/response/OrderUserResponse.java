package com.spring.demo.model.response;

import java.util.Date;
import java.util.List;

public class OrderUserResponse {

    private Long orderID;

    private String customerName;

    public Long getOrderID() {
        return orderID;
    }

    public OrderUserResponse() {
    }

    public OrderUserResponse(Long orderID, String customerName, List<String> orderdItems, Date orderedDate, String email) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.orderdItems = orderdItems;
        this.orderedDate = orderedDate;

        this.email = email;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getOrderdItems() {
        return orderdItems;
    }

    public void setOrderdItems(List<String> orderdItems) {
        this.orderdItems = orderdItems;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private List<String> orderdItems;

    private Date orderedDate;

    private String email;
}
