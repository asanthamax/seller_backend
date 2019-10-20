package com.spring.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "shippingAddress")
    private String shippingAddress;

    public Customer(String shippingAddress, int postalcode, String city, String county, SystemUser user) {
        this.shippingAddress = shippingAddress;
        this.postalcode = postalcode;
        this.city = city;
        this.county = county;
        this.user = user;
    }

    public int getPostalcode() {

        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Column(name = "postal_code")
    private int postalcode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String county;

    public Customer() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "User_userID")
    @OnDelete(action = OnDeleteAction.CASCADE)

    private SystemUser user;
}
