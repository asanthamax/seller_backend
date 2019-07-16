package com.spring.demo.repository;

import com.spring.demo.entity.Payments;
import com.spring.demo.entity.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentsRepository extends PagingAndSortingRepository<Payments, Long> {

    @Query("SELECT payments FROM Payments payments WHERE payments.paymentStatus = :paymentStatus")
    Page<Payments> findPaymentsToPaid(@Param("paymentStatus") String paymentStatus, Pageable pageable);

    @Query("SELECT payments FROM Payments payments WHERE payments.seller.sellerID = :sellerID")
    List<Payments> findPaymentBySeller(@Param("sellerID") Long sellerID);

}
