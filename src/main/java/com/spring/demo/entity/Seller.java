package com.spring.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sellerID")
    private Long sellerID;

    public Seller(String address, SystemUser uerID) {
        this.address = address;
        this.uerID = uerID;
    }

    public Seller() {
    }

    public Long getSellerID() {


        return sellerID;
    }

    public void setSellerID(Long sellerID) {
        this.sellerID = sellerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SystemUser getUerID() {
        return uerID;
    }

    public void setUerID(SystemUser uerID) {
        this.uerID = uerID;
    }

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "User_userID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SystemUser uerID;
}
