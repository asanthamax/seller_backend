package com.spring.demo.model.response;


import org.springframework.stereotype.Repository;

import java.util.List;

public class OrderProductVariationResponse {

    private String productName;

    public OrderProductVariationResponse(String productName, List<ProductVariationResponse> productVariation) {
        this.productName = productName;
        this.productVariation = productVariation;
    }

    public OrderProductVariationResponse() {
    }

    public String getProductName() {
        return productName;

    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ProductVariationResponse> getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(List<ProductVariationResponse> productVariation) {
        this.productVariation = productVariation;
    }

    private List<ProductVariationResponse> productVariation;

}
