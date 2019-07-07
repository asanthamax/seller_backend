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

    public Customer() {
    }

    public Customer(String shippingAddress, SystemUser user) {
        this.shippingAddress = shippingAddress;
        this.user = user;
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
