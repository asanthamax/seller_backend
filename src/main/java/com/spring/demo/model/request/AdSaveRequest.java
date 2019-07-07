package com.spring.demo.model.request;

public class AdSaveRequest {

    private Long adId;

    public Long getAdId() {
        return adId;
    }

    public AdSaveRequest() {
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public AdSaveRequest(Long adId, Long adSlotId, String remarks, int status) {
        this.adId = adId;
        this.adSlotId = adSlotId;
        this.remarks = remarks;
        this.status = status;
    }

    public Long getAdSlotId() {
        return adSlotId;
    }

    public void setAdSlotId(Long adSlotId) {
        this.adSlotId = adSlotId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private Long adSlotId;

    private String remarks;

    private int status;
}
