package com.spring.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderProductIdClass implements Serializable {

    @Column(name = "order_id")
    private Long orderId;

    public OrderProductIdClass() {
    }

    public OrderProductIdClass(Long orderId, Long productVaritation) {
        this.orderId = orderId;
        this.productVaritation = productVaritation;
    }

    public Long getOrderId() {

        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductVaritation() {
        return productVaritation;
    }

    public void setProductVaritation(Long productVaritation) {
        this.productVaritation = productVaritation;
    }

    @Column(name = "product_variation_id")
    private Long productVaritation;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return (prime * result + ((orderId == null) ? 0 : orderId.hashCode()) + prime * result + ((productVaritation == null) ? 0 : productVaritation.hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderProductIdClass other = (OrderProductIdClass) obj;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        if (productVaritation == null) {
            if (other.productVaritation != null)
                return false;
        } else if (!productVaritation.equals(other.productVaritation))
            return false;
        return true;
    }
}
