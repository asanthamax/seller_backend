package com.spring.demo.repository;

import com.spring.demo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Query("SELECT customer FROM Customer customer " +
            "INNER JOIN FETCH customer.user " +
            "WHERE customer.id = :id")
    Optional<Customer> findById(Long id);

}
