package com.spring.demo.model.response;

import java.util.Date;

public class WishListResponse {

    private long id;

    private String customerName;

    private String wishListItem;

    public WishListResponse() {
    }

    public WishListResponse(long id, String customerName, String wishListItem, Date addedDate, String email) {
        this.id = id;
        this.customerName = customerName;
        this.wishListItem = wishListItem;
        this.addedDate = addedDate;

        this.email = email;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getWishListItem() {
        return wishListItem;
    }

    public void setWishListItem(String wishListItem) {
        this.wishListItem = wishListItem;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Date addedDate;

    private String email;
}
