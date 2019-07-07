package com.spring.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryID")
    private Long categoryId;

    public ProductCategory(String categoryName, String categorySlug, int isParentCategory, Long parentCategoryId, Date createdDate, int isActive) {
        this.categoryName = categoryName;
        this.categorySlug = categorySlug;
        this.isParentCategory = isParentCategory;
        this.parentCategoryId = parentCategoryId;
        this.createdDate = createdDate;
        this.isActive = isActive;
    }

    public ProductCategory() {
    }

    public Long getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    public int getIsParentCategory() {
        return isParentCategory;
    }

    public void setIsParentCategory(int isParentCategory) {
        this.isParentCategory = isParentCategory;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Column(name = "categoryName", nullable = false)

    private String categoryName;

    @Column(name = "categorySlug", nullable = false)
    private String categorySlug;

    @Column(name = "isParentCategory", nullable = false)
    private int isParentCategory;

    @Column(name = "parentCategoryID", nullable = false)
    private Long parentCategoryId;

    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    @Column(name = "isActive", nullable = false)
    private int isActive;
}
