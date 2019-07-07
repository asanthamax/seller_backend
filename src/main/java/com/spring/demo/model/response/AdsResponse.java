package com.spring.demo.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AdsResponse {

    private Long id;

    @JsonFormat(pattern = "yyyy-mm-dd H:i:s")
    private Date publishedDate;

    private String adImage;

    private Long adSlot;

    private String customerName;

    public Long getAdSlot() {
        return adSlot;
    }

    public void setAdSlot(Long adSlot) {
        this.adSlot = adSlot;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    private String customerEmail;

    public AdsResponse() {
    }

    public AdsResponse(Long id, Date publishedDate, String adImage, int adStatus,
                       Long adSlot, String customerName, String customerEmail) {

        this.id = id;
        this.publishedDate = publishedDate;
        this.adImage = adImage;
        this.adStatus = adStatus;
        this.adSlot = adSlot;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAdImage() {
        return adImage;
    }

    public void setAdImage(String adImage) {
        this.adImage = adImage;
    }

    public int getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(int adStatus) {
        this.adStatus = adStatus;
    }

    private int adStatus;
}
