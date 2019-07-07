package com.spring.demo.repository;

import com.spring.demo.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {

    @Query("SELECT productImages FROM ProductImages productImages " +
            "INNER JOIN productImages.variation " +
            "WHERE productImages.product.productId = :productID")
    List<ProductImages> findByProductID(@Param("productID") Long productID);
}
