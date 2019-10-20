package com.spring.demo.repository;

import com.spring.demo.entity.WIshlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends PagingAndSortingRepository<WIshlist,Long> {

    @Query("SELECT wishlist FROM WIshlist wishlist INNER JOIN wishlist.customer as customer WHERE customer.id = :customerID")
    Page<WIshlist> findByCustomerID(@Param("customerID") long customerID, Pageable pageable);
}
