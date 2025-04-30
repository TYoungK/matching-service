package com.taekyoungk.matching_service.domain.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taekyoungk.matching_service.domain.coupon.dto.CouponDto;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponListResponse;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponSaveRequest;
import com.taekyoungk.matching_service.domain.coupon.service.CouponService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping
    public ResponseEntity<CouponDto> createCoupon(CouponSaveRequest couponSaveRequest) {
        return ResponseEntity.ok(couponService.create(couponSaveRequest));
    }
    
    @GetMapping
    public ResponseEntity<CouponListResponse> getCouponsByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(couponService.getCouponsByUserId(userId));
    }
    
}
