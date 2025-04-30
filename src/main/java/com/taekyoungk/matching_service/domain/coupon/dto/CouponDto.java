package com.taekyoungk.matching_service.domain.coupon.dto;

import java.time.LocalDate;

public class CouponDto {
    private int idx;
    private String userId;
    private byte discountPercent;
    private int maxDiscountCost;
    private LocalDate expirationDate;

    public CouponDto(int idx, String userId, byte discountPercent, int maxDiscountCost, LocalDate expirationDate) {
        this.idx = idx;
        this.userId = userId;
        this.discountPercent = discountPercent;
        this.maxDiscountCost = maxDiscountCost;
        this.expirationDate = expirationDate;
    }

    public int getIdx() {
        return idx;
    }

    public String getUserId() {
        return userId;
    }

    public byte getDiscountPercent() {
        return discountPercent;
    }

    public int getMaxDiscountCost() {
        return maxDiscountCost;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    
}
