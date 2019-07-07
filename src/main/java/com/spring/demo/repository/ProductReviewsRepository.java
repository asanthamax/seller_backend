package com.spring.demo.repository;

import com.spring.demo.entity.ProductReviews;
import com.spring.demo.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductReviewsRepository extends JpaRepository<ProductReviews, Long> {

    @Query("SELECT reviews FROM ProductReviews reviews WHERE reviews.products.productId = :productID")
    List<ProductReviews> findByProductId(@Param("productID") Long productID);
}
