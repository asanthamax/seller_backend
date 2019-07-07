package com.spring.demo.model.response;

import com.spring.demo.entity.*;

import java.util.Date;
import java.util.List;

public class ProductResponse {

    private Long productId;

    private String sku;

    private String barcode;

    private String productSlug;

    private String productName;

    private String productDescription;

    public ProductResponse() {
    }

    private Double regularPrice;

    private Double salePrice;

    private int stock;

    public ProductResponse(Long productId, String sku, String barcode, String productSlug, String productName, String productDescription, Double regularPrice, Double salePrice, int stock, int stockStatus, Double weight, String weightUnit, String productType, int isSample, Double samplePrice, int isActive, Date createdDate, Date modifiedDate, ProductCategory category, SystemUser user, List<ProductReviews> productReviews, List<ProductTags> productTags, List<VariationsAndImages> productVariations) {
        this.productId = productId;
        this.sku = sku;
        this.barcode = barcode;
        this.productSlug = productSlug;
        this.productName = productName;
        this.productDescription = productDescription;
        this.regularPrice = regularPrice;
        this.salePrice = salePrice;
        this.stock = stock;
        this.stockStatus = stockStatus;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.productType = productType;
        this.isSample = isSample;
        this.samplePrice = samplePrice;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.category = category;
        this.user = user;
        this.productReviews = productReviews;
        this.productTags = productTags;
        this.productVariations = productVariations;
    }

    private int stockStatus;

    private Double weight;

    private String weightUnit;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public void setProductSlug(String productSlug) {
        this.productSlug = productSlug;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(Double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(int stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getIsSample() {
        return isSample;
    }

    public void setIsSample(int isSample) {
        this.isSample = isSample;
    }

    public Double getSamplePrice() {
        return samplePrice;
    }

    public void setSamplePrice(Double samplePrice) {
        this.samplePrice = samplePrice;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    public List<ProductReviews> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(List<ProductReviews> productReviews) {
        this.productReviews = productReviews;
    }

    public List<ProductTags> getProductTags() {
        return productTags;
    }

    public void setProductTags(List<ProductTags> productTags) {
        this.productTags = productTags;
    }

    public List<VariationsAndImages> getProductVariations() {
        return productVariations;
    }

    public void setProductVariations(List<VariationsAndImages> productVariations) {
        this.productVariations = productVariations;
    }

    private String productType;

    private int isSample;

    private Double samplePrice;

    private int isActive;

    private Date createdDate;

    private Date modifiedDate;

    private ProductCategory category;

    private SystemUser user;

    private List<ProductReviews> productReviews;

    private List<ProductTags> productTags;

    private List<VariationsAndImages> productVariations;
}
