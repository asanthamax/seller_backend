package com.spring.demo.model.response;

public class SliderResponse {

    private Long sliderID;

    private String slideURL;

    public Long getSliderID() {
        return sliderID;
    }

    public SliderResponse(Long sliderID, String slideURL, int sliderOrder, String sliderTitle) {
        this.sliderID = sliderID;
        this.slideURL = slideURL;
        this.sliderOrder = sliderOrder;
        this.sliderTitle = sliderTitle;
    }

    public SliderResponse() {
    }

    public String getSlideURL() {
        return slideURL;
    }

    public void setSlideURL(String slideURL) {
        this.slideURL = slideURL;
    }

    public String getSliderTitle() {
        return sliderTitle;
    }

    public void setSliderTitle(String sliderTitle) {
        this.sliderTitle = sliderTitle;
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

    private int sliderOrder;

    private String sliderTitle;
}
