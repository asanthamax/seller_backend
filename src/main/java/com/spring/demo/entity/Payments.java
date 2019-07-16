package com.spring.demo.entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sellerpayments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Payments() {
    }

    public Payments(Date recievedDate, Date settlementDate, double amount, Date paymentDate, String paymentStatus, int status, Seller seller, Invoice invoice) {
        this.recievedDate = new Date(recievedDate.getTime());
        this.settlementDate = new Date(settlementDate.getTime());
        this.amount = amount;
        this.paymentDate = new Date(paymentDate.getTime());
        this.paymentStatus = paymentStatus;
        this.status = status;

        this.seller = seller;
        this.invoice = invoice;
    }

    @Column(name = "recievedDate")

    private Date recievedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRecievedDate() {
        return new Date(recievedDate.getTime());
    }

    public void setRecievedDate(Date recievedDate) {
        this.recievedDate = new Date(recievedDate.getTime());
    }

    public Date getSettlementDate() {
        return new Date(settlementDate.getTime());
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = new Date(settlementDate.getTime());
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return new Date(paymentDate.getTime());
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = new Date(paymentDate.getTime());
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public void setInvoice(Invoice invoice) {

        this.invoice = invoice;
    }

    @Column(name = "settlementDate")
    private Date settlementDate;

    @Column(name = "amount")
    private double amount;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "paymentStatus")
    private String paymentStatus;

    @Column(name = "status")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_userID")
    private Seller seller;

    public Double getTotalSumAmount() {
        return totalSumAmount;
    }

    public void setTotalSumAmount(Double totalSumAmount) {
        this.totalSumAmount = totalSumAmount;
    }

    public Double getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(Double totalPayable) {
        this.totalPayable = totalPayable;
    }

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_invoiceID")
    private Invoice invoice;

    @Formula(value = "SELECT SUM(payments.amount) FROM Payments payments WHERE payments.User_userID = id")
    private Double totalAmount;

    @Formula(value = "SELECT SUM(payments) FROM Payments payments WHERE payments.User_userID = id")
    private int totalOrders;

    @Formula(value = "SELECT SUM(payments.amount) FROM Payments payments")
    private Double totalSumAmount;

    @Formula(value = "SELECT SUM(payments.amount) FROM Payments payments WHERE payments.paymentStatus = 'Pending'")
    private Double totalPayable;

    @Formula(value = "SELECT SUM(payments.amount) FROM Payments payments WHERE payments.paymentStatus = 'Paid'")
    private Double totalPaid;
}
