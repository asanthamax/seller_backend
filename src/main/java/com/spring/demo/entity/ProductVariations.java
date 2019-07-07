package com.spring.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "variations")
public class ProductVariations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public ProductVariations() {
    }

    public ProductVariations(String variationSku, String varriationAttribute, String variationValue, Double variationRegularPrice, Double variationSalePrice, Products product) {
        this.variationSku = variationSku;
        this.varriationAttribute = varriationAttribute;
        this.variationValue = variationValue;
        this.variationRegularPrice = variationRegularPrice;

        this.variationSalePrice = variationSalePrice;
        this.product = product;
    }

    @Column(name = "variationSku")

    private String variationSku;

    @Column(name = "varriationAttribute")
    private String varriationAttribute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariationSku() {
        return variationSku;
    }

    public void setVariationSku(String variationSku) {
        this.variationSku = variationSku;
    }

    public String getVarriationAttribute() {
        return varriationAttribute;
    }

    public void setVarriationAttribute(String varriationAttribute) {
        this.varriationAttribute = varriationAttribute;
    }

    public String getVariationValue() {
        return variationValue;
    }

    public void setVariationValue(String variationValue) {
        this.variationValue = variationValue;
    }

    public Double getVariationRegularPrice() {
        return variationRegularPrice;
    }

    public void setVariationRegularPrice(Double variationRegularPrice) {
        this.variationRegularPrice = variationRegularPrice;
    }

    public Double getVariationSalePrice() {
        return variationSalePrice;
    }

    public void setVariationSalePrice(Double variationSalePrice) {
        this.variationSalePrice = variationSalePrice;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Column(name = "variationValue")
    private String variationValue;

    @Column(name = "variationRegularPrice")
    private Double variationRegularPrice;

    @Column(name = "variationSalePrice")
    private Double variationSalePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_prouctID")
    private Products product;
}
