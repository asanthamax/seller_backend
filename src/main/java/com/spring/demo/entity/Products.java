package com.spring.demo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "product")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productID")
    private Long productId;

    public Products() {
    }

    @Column(name = "sku")
    private String sku;

    public Products(String sku, String barcode, String productSlug, String productName, String productDescription, Double regularPrice, Double salePrice, int stock, int stockStatus, Double weight, String weightUnit, String productType, int isSample, Double samplePrice, int isActive, Date createdDate, Date modifiedDate, ProductCategory category, SystemUser user,Collection<ProductTags> productTags) {
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
        this.tags = productTags;
    }

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "productSlug")
    private String productSlug;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "regularPrice")
    private Double regularPrice;

    @Column(name = "salePrice")
    private Double salePrice;

    @Column(name = "stock")
    private int stock;

    @Column(name = "stockStatus")
    private int stockStatus;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "weightUnit")
    private String weightUnit;

    @Column(name = "productType")
    private String productType;

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

    @Column(name = "isSample")

    private int isSample;

    @Column(name = "samplePrice")
    private Double samplePrice;

    @Column(name = "isActive")
    private int isActive;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "modifiedDate")
    private Date modifiedDate;

    public Collection<ProductTags> getTags() {
        return tags;
    }

    public void setTags(Collection<ProductTags> tags) {
        this.tags = tags;
    }

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "Categories_categoryID")
    private ProductCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_userID")
    private SystemUser user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_has_tags", joinColumns = @JoinColumn(name = "Product_prouctID", referencedColumnName = "productID"), inverseJoinColumns = @JoinColumn(name = "Tags_tagId", referencedColumnName = "tagId"))
    private Collection<ProductTags> tags;
}
