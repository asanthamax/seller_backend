package com.spring.demo.repository;

import com.spring.demo.entity.AdSlots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdSlotsRepository extends JpaRepository<AdSlots, Long> {
}
