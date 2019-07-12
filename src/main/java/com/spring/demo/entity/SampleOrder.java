package com.spring.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "ordersamplerequests")
public class SampleOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sampleID")
    private Long sampleID;

    public SampleOrder() {
    }

    public SampleOrder(Order order) {

        this.order = order;
    }

    public Long getSampleID() {

        return sampleID;
    }

    public void setSampleID(Long sampleID) {
        this.sampleID = sampleID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Orders_orderID", nullable = false)
    private Order order;
}
