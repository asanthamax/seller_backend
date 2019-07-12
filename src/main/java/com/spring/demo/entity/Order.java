package com.spring.demo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderID")
    private Long orderID;

    @Column(name = "orderedDate")
    private Date orderedDate;

    @Column(name = "orderAmount")
    private String orderAmount;

    public Long getOrderID() {
        return orderID;
    }

    public Order() {
    }

    public Order(Date orderedDate, String orderAmount, double quantity, String quantity_unit, int orderStatus, String remarks, Customer customer, Seller seller, ShippingMethod shippingMethod, Collection<Products> product, Collection<ProductVariations> productVariation, String orderType) {
        this.orderedDate = orderedDate;
        this.orderAmount = orderAmount;
        this.quantity = quantity;
        this.quantity_unit = quantity_unit;
        this.orderStatus = orderStatus;
        this.remarks = remarks;
        this.customer = customer;
        this.seller = seller;
        this.shippingMethod = shippingMethod;
        this.product = product;
        this.productVariation = productVariation;
        this.orderType = orderType;
    }

    public void setOrderID(Long orderID) {

        this.orderID = orderID;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getQuantity_unit() {
        return quantity_unit;
    }

    public void setQuantity_unit(String quantity_unit) {
        this.quantity_unit = quantity_unit;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Collection<Products> getProduct() {
        return product;
    }

    public void setProduct(Collection<Products> product) {
        this.product = product;
    }

    public Collection<ProductVariations> getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(Collection<ProductVariations> productVariation) {
        this.productVariation = productVariation;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "quantity_unit")
    private String quantity_unit;

    @Column(name = "orderStatus")
    private int orderStatus;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_userID")
    private Seller seller;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShippingMethod_id")
    private ShippingMethod shippingMethod;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orderproduct", joinColumns = @JoinColumn(name = "Orders_orderID", referencedColumnName = "orderID"), inverseJoinColumns = @JoinColumn(name = "orderProductID", referencedColumnName = "productID"))
    private Collection<Products> product;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private Collection<ProductVariations> productVariation;

    @Column(name = "orderType")
    private String orderType;

}
