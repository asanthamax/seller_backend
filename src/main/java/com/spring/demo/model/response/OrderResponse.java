package com.spring.demo.model.response;

import com.spring.demo.entity.Customer;
import com.spring.demo.entity.Seller;
import com.spring.demo.entity.ShippingMethod;

import java.util.Date;
import java.util.List;

public class OrderResponse {
    public Long getOrderID() {
        return orderID;
    }

    public OrderResponse() {
    }

    public OrderResponse(Long orderID, Date orderDate, String orderAmount, Customer customer, Seller seller, ShippingMethod shippingMethod, List<OrderProductVariationResponse> orderVariation) {
        this.orderID = orderID;
        this.orderDate = new Date(orderDate.getTime());
        this.orderAmount = orderAmount;
        this.customer = customer;
        this.seller = seller;
        this.shippingMethod = shippingMethod;
        this.orderVariation = orderVariation;

    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;

    }

    public Date getOrderDate() {
        return new Date(orderDate.getTime());
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = new Date(orderDate.getTime());
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public List<OrderProductVariationResponse> getOrderVariation() {
        return orderVariation;
    }

    public void setOrderVariation(List<OrderProductVariationResponse> orderVariation) {
        this.orderVariation = orderVariation;
    }

    private Long orderID;

    private Date orderDate;

    private String orderAmount;

    private Customer customer;

    private Seller seller;

    private ShippingMethod shippingMethod;

    private List<OrderProductVariationResponse> orderVariation;

}
