package com.spring.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "productimages")
public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public ProductImages() {
    }

    @Column(name = "imgPath")
    private String imgPath;

    public Long getId() {
        return id;
    }

    public ProductImages(String imgPath, String imgUrl, String imgName, String imgExt, int isCover, Products product, ProductVariations variation) {
        this.imgPath = imgPath;
        this.imgUrl = imgUrl;
        this.imgName = imgName;
        this.imgExt = imgExt;
        this.isCover = isCover;
        this.product = product;
        this.variation = variation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgExt() {
        return imgExt;
    }

    public void setImgExt(String imgExt) {
        this.imgExt = imgExt;
    }

    public int getIsCover() {
        return isCover;
    }

    public void setIsCover(int isCover) {
        this.isCover = isCover;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public ProductVariations getVariation() {
        return variation;
    }

    public void setVariation(ProductVariations variation) {
        this.variation = variation;
    }

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "imgName")
    private String imgName;

    @Column(name = "imgExt")
    private String imgExt;

    @Column(name = "isCover")
    private int isCover;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_prouctID")
    private Products product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variationID")
    private ProductVariations variation;
}
