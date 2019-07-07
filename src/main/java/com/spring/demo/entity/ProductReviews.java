package com.spring.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productreviews")
public class ProductReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public ProductReviews() {
    }

    @Column(name = "ratingScore")
    private Double ratingScore;

    public Long getId() {
        return id;
    }

    public ProductReviews(Double ratingScore, String review, Date reviewDate, int reviewStatus, Products products, Customer customer) {
        this.ratingScore = ratingScore;
        this.review = review;
        this.reviewDate = reviewDate;
        this.reviewStatus = reviewStatus;
        this.products = products;
        this.customer = customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(Double ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(int reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "review")
    private String review;

    @Column(name = "reviewDate")
    private Date reviewDate;

    @Column(name = "reviewStatus")
    private int reviewStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_prouctID")
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_userID")
    private Customer customer;
}
