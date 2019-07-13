package com.spring.demo.repository;

import com.spring.demo.entity.Messages;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends PagingAndSortingRepository<Messages, Long> {

    @Query("SELECT messages FROM Messages messages INNER JOIN messages.order WHERE messages.order.orderID = :id")
    Page<Messages> findByOrderId(@Param("id") Long id);
}