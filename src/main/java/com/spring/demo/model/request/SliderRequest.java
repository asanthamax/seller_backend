package com.spring.demo.model.request;

public class SliderRequest {

    private Long sliderID;

    private String sliderTitle;

    public SliderRequest(Long sliderID, String sliderTitle, int sliderOrder) {
        this.sliderID = sliderID;
        this.sliderTitle = sliderTitle;
        this.sliderOrder = sliderOrder;
    }

    public SliderRequest() {
    }

    public Long getSliderID() {
        return sliderID;


    }

    public void setSliderID(Long sliderID) {
        this.sliderID = sliderID;
    }

    public int getSliderOrder() {
        return sliderOrder;
    }

    public void setSliderOrder(int sliderOrder) {
        this.sliderOrder = sliderOrder;
    }

    public String getSliderTitle() {

        return sliderTitle;
    }

    public void setSliderTitle(String sliderTitle) {
        this.sliderTitle = sliderTitle;
    }

    private int sliderOrder;
}
