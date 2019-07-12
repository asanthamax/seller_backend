package com.spring.demo.repository;

import com.spring.demo.entity.OrderProdutVariation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductVariationRepository extends JpaRepository<OrderProdutVariation, Long> {

    @Query("SELECT order_product FROM OrderProdutVariation order_product " +
            "INNER JOIN  order_product.variations as variations WHERE order_product.variations.id = :id")
    List<OrderProdutVariation> findByVariationId(@Param("id") Long id);
}
