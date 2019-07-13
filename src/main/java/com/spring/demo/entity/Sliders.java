package com.spring.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "slideshowimages")
public class Sliders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name="imgUrl")
    private String imgUrl;

    public Sliders() {
    }

    public Sliders(String imgUrl, String absPath, int sliderOrder, int status, String slideTitle) {
        this.imgUrl = imgUrl;
        this.absPath = absPath;
        this.sliderOrder = sliderOrder;
        this.status = status;

        this.slideTitle = slideTitle;
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAbsPath() {
        return absPath;
    }

    public void setAbsPath(String absPath) {
        this.absPath = absPath;
    }

    public int getSliderOrder() {
        return sliderOrder;
    }

    public void setSliderOrder(int sliderOrder) {
        this.sliderOrder = sliderOrder;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSlideTitle() {
        return slideTitle;
    }

    public void setSlideTitle(String slideTitle) {
        this.slideTitle = slideTitle;
    }

    @Column(name = "absPath")
    private String absPath;

    @Column(name = "slideOrder")
    private int sliderOrder;

    @Column(name = "status")
    private int status;

    @Column(name = "slider_title")
    private String slideTitle;
}
