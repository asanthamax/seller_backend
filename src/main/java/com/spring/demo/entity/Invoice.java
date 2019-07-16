package com.spring.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoiceID")
    private Long invoiceID;

    public Long getInvoiceID() {
        return invoiceID;
    }

    public Invoice(String invoiceNum, Date invoiceDate, double paymentAmount, Date paymentDate, Order order) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = new Date(invoiceDate.getTime());
        this.paymentAmount = paymentAmount;
        this.paymentDate = new Date(paymentDate.getTime());
        this.order = order;
    }

    public Invoice() {
    }

    public void setInvoiceID(Long invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getInvoiceDate() {
        return new Date(invoiceDate.getTime());
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = new Date(invoiceDate.getTime());
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return new Date(paymentDate.getTime());
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = new Date(paymentDate.getTime());
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Column(name = "invoiceNum", unique = true)

    private String invoiceNum;

    @Column(name = "invoiceDate")
    private Date invoiceDate;

    @Column(name = "paymentAmount")
    private double paymentAmount;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Orders_orderID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;

}
