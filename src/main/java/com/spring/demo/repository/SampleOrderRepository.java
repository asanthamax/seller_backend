package com.spring.demo.repository;


import com.spring.demo.entity.SampleOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleOrderRepository extends PagingAndSortingRepository<SampleOrder, Long> {

    @Query("SELECT samples FROM SampleOrder samples INNER JOIN samples.order as order INNER JOIN order.seller as seller WHERE seller.sellerID = :sellerID")
    Page<SampleOrder> findAllSamplesByUser(@Param("sellerID") long sellerID, Pageable pageable);
}
