package com.spring.demo.repository;

import com.spring.demo.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    @Query("SELECT orders FROM Order orders INNER JOIN orders.seller AS seller WHERE orders.seller.orderID")
    Page<Order> getOrdersBySeller(Long sellerID, Pageable pageable);
}
