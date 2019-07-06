package com.spring.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "adslots")
public class AdSlots {

    public AdSlots() {
    }

    public AdSlots(String addLocation, String width, String height, String price) {

        this.addLocation = addLocation;
        this.width = width;
        this.height = height;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "addLocation")
    private String addLocation;

    @Column(name = "width")
    private String width;

    @Column(name = "height")
    private String height;

    @Column(name = "price")
    private String price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddLocation() {
        return addLocation;
    }

    public void setAddLocation(String addLocation) {
        this.addLocation = addLocation;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
