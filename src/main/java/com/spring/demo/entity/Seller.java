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

    public Seller(String address, String city, String country, int postalCode, SystemUser uerID) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.uerID = uerID;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "postal_code")
    private int postalCode;

    @OneToOne
    @JoinColumn(name = "User_userID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SystemUser uerID;
}
