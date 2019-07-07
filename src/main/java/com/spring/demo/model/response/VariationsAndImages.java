package com.spring.demo.model.response;

import com.spring.demo.entity.ProductImages;

import java.util.List;

public class VariationsAndImages {

    private String variationSku;

    private String varriationAttribute;

    public VariationsAndImages() {
    }

    public VariationsAndImages(String variationSku, String varriationAttribute, String variationValue, Double variationRegularPrice, Double variationSalePrice, List<ProductImages> productImages) {
        this.variationSku = variationSku;
        this.varriationAttribute = varriationAttribute;
        this.variationValue = variationValue;
        this.variationRegularPrice = variationRegularPrice;
        this.variationSalePrice = variationSalePrice;
        this.productImages = productImages;

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

    public List<ProductImages> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImages> productImages) {
        this.productImages = productImages;
    }

    private String variationValue;

    private Double variationRegularPrice;

    private Double variationSalePrice;

    private List<ProductImages> productImages;
}
