package com.spring.demo.repository;

import com.spring.demo.entity.Ads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepository extends PagingAndSortingRepository<Ads, Long> {

    Page<Ads> findById(Long id, Pageable page);
}
