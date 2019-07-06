package com.spring.demo.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AdsResponse {

    private Long id;

    @JsonFormat(pattern = "yyyy-mm-dd H:i:s")
    private Date publishedDate;

    private String adImage;

    public AdsResponse() {
    }

    public AdsResponse(Long id, Date publishedDate, String adImage, int adStatus) {

        this.id = id;
        this.publishedDate = publishedDate;
        this.adImage = adImage;
        this.adStatus = adStatus;
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
