package com.spring.demo.repository;

import com.spring.demo.entity.ResetPassword;
import com.spring.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResetPasswordRepository extends JpaRepository<ResetPassword, Long> {


    @Query("SELECT DISTINCT reset FROM ResetPassword  reset WHERE reset.user = :user_id")
    Optional<ResetPassword> findByUserId(@Param("user_id") User user);

}
