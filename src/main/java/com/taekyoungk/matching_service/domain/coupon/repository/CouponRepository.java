package com.taekyoungk.matching_service.domain.coupon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taekyoungk.matching_service.domain.coupon.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer>{
    List<Coupon> findAllByUser_Id(String userId);
}

