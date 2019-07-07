package com.spring.demo.repository;

import com.spring.demo.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {

    @Query("SELECT products FROM Products products INNER JOIN products.tags AS tags")
    Page<Products> findAll(Pageable pageable);
}
