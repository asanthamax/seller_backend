package com.spring.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderproduct_variations")
public class OrderProdutVariation {

    public Order getOder() {
        return oder;
    }

    public OrderProdutVariation(Order oder, ProductVariations variations, double quantity) {
        this.oder = oder;
        this.variations = variations;
        this.quantity = quantity;
    }

    public OrderProductIdClass getId() {
        return id;
    }

    public void setId(OrderProductIdClass id) {
        this.id = id;
    }

    public OrderProdutVariation() {
    }

    public void setOder(Order oder) {

        this.oder = oder;
    }

    public ProductVariations getVariations() {
        return variations;
    }

    public void setVariations(ProductVariations variations) {
        this.variations = variations;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "order_id")
    @JoinColumn(name = "order_id", nullable = false)
    private Order oder;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "product_variation_id")
    @JoinColumn(name = "product_variation_id", nullable = false)
    private ProductVariations variations;

    @Column(name = "quantity")
    private double quantity;

    @EmbeddedId
    private OrderProductIdClass id;
}
