package com.taekyoungk.matching_service.domain.coupon.dto;

public class CouponValidationRequest {
    private String userId;
    private int couponIdx;

    
    public CouponValidationRequest(String userId, int couponIdx) {
        this.userId = userId;
        this.couponIdx = couponIdx;
    }
    public String getUserId() {
        return userId;
    }
    public int getCouponIdx() {
        return couponIdx;
    }
    
}