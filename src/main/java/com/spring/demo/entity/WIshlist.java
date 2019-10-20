package com.spring.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wishlist")
public class WIshlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public WIshlist() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")

    private Customer customer;

    public long getId() {
        return id;
    }

    public WIshlist(Customer customer, ProductVariations productVariations, Date addedDate) {
        this.customer = customer;
        this.productVariations = productVariations;
        this.addedDate = addedDate;
    }

    public void setId(long id) {

        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ProductVariations getProductVariations() {
        return productVariations;
    }

    public void setProductVariations(ProductVariations productVariations) {
        this.productVariations = productVariations;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productID")
    private ProductVariations productVariations;

    @Column(name = "added_date")
    private Date addedDate;
}
