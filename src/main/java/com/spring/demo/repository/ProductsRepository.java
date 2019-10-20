package com.spring.demo.repository;

import com.spring.demo.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {

    @Query("SELECT products FROM Products products LEFT JOIN products.tags AS tags")
    Page<Products> findAll(Pageable pageable);

    @Query("SELECT products FROM Products products INNER JOIN products.user as seller WHERE seller.userId = :sellerID")
    Page<Products> findProductsBySeller(@Param("sellerID") Long sellerID, Pageable pageable);
}
