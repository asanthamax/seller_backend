package com.spring.demo.repository;

import com.spring.demo.entity.Sliders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderRepository extends JpaRepository<Sliders, Long> {
}
