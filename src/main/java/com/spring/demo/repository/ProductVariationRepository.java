package com.spring.demo.repository;

import com.spring.demo.entity.ProductVariations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductVariationRepository extends JpaRepository<ProductVariations, Long> {

    @Query("SELECT variations FROM ProductVariations variations WHERE variations.product.productId = :productID")
    List<ProductVariations> findByProductID(@Param("productID") Long productID);
}
