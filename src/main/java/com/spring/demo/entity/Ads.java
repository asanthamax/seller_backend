package com.spring.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ads")
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "imgPath")
    private String imgPath;

    @Column(name = "status")
    private int status;

    public Long getId() {
        return id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AdSlots getAdSlotId() {
        return adSlotId;
    }

    public void setAdSlotId(AdSlots adSlotId) {
        this.adSlotId = adSlotId;
    }

    public Customer getUserId() {
        return userId;
    }

    public void setUserId(Customer userId) {
        this.userId = userId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getStart_at() {
        return start_at;
    }

    public void setStart_at(Date start_at) {
        this.start_at = start_at;
    }

    public Date getExpire_at() {
        return expire_at;
    }

    public void setExpire_at(Date expire_at) {
        this.expire_at = expire_at;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AdSlots_id", nullable = false)
    private AdSlots adSlotId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_userID", nullable = false)
    private Customer userId;

    public Ads() {
    }

    public Ads(String imgPath, int status, AdSlots adSlotId, Customer userId, String remarks, Date created_at, Date start_at, Date expire_at) {

        this.imgPath = imgPath;
        this.status = status;
        this.adSlotId = adSlotId;
        this.userId = userId;
        this.remarks = remarks;
        this.created_at = created_at;
        this.start_at = start_at;
        this.expire_at = expire_at;
    }

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "createdDate")
    private Date created_at;

    @Column(name = "startDate")
    private Date start_at;

    @Column(name = "expireDate")
    private Date expire_at;
}
