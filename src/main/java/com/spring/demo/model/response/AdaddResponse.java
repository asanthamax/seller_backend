package com.spring.demo.model.response;

import java.util.Date;

public class AdaddResponse {

    private Long adId;

    public AdaddResponse() {
    }

    private Date approveRejectDatetime;

    public Long getAdId() {
        return adId;
    }

    public AdaddResponse(Long adId, Date approveRejectDatetime, String message) {
        this.adId = adId;
        this.approveRejectDatetime = new Date(approveRejectDatetime.getTime());
        this.message = message;
    }

    public void setAdId(Long adId) {

        this.adId = adId;
    }

    public Date getApproveRejectDatetime() {
        return new Date(approveRejectDatetime.getTime());
    }

    public void setApproveRejectDatetime(Date approveRejectDatetime) {
        this.approveRejectDatetime = new Date(approveRejectDatetime.getTime());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

}
