package com.spring.demo.repository;

import com.spring.demo.entity.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingMethod, Long> {
}
