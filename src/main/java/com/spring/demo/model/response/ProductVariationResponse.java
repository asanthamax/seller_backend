package com.spring.demo.model.response;

public class ProductVariationResponse {

    private String variation;

    public String getVariation() {
        return variation;
    }

    public ProductVariationResponse(String variation, double variationPrice, double qunatity, double totalPrice) {
        this.variation = variation;
        this.variationPrice = variationPrice;
        this.qunatity = qunatity;
        this.totalPrice = totalPrice;
    }

    public ProductVariationResponse() {
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public double getVariationPrice() {
        return variationPrice;
    }

    public void setVariationPrice(double variationPrice) {
        this.variationPrice = variationPrice;
    }

    public double getQunatity() {
        return qunatity;
    }

    public void setQunatity(double qunatity) {
        this.qunatity = qunatity;
    }

    private double variationPrice;

    private double qunatity;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    private double totalPrice;
}
