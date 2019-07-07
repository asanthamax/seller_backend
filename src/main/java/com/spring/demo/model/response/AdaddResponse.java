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
        this.approveRejectDatetime = approveRejectDatetime;
        this.message = message;
    }

    public void setAdId(Long adId) {

        this.adId = adId;
    }

    public Date getApproveRejectDatetime() {
        return approveRejectDatetime;
    }

    public void setApproveRejectDatetime(Date approveRejectDatetime) {
        this.approveRejectDatetime = approveRejectDatetime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

}
