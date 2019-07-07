package com.spring.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class ProductTags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tagId")
    private Long tagId;

    public ProductTags() {
    }

    public ProductTags(String tagName, int hitCount, int isActive) {
        this.tagName = tagName;
        this.hitCount = hitCount;
        this.isActive = isActive;
    }

    public Long getTagId() {
        return tagId;

    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Column(name = "tagName")
    private String tagName;

    @Column(name = "hitCount")
    private int hitCount;

    @Column(name = "isActive")
    private int isActive;
}
