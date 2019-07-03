package com.spring.demo.repository;

import com.spring.demo.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

    Optional<RoomEntity> findById(Long id);
}
