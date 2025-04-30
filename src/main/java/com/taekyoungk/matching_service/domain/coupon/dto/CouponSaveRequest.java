package com.taekyoungk.matching_service.domain.coupon.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

public class CouponSaveRequest {
    private String userId;
    @Schema(
        description = "할인률 (tinyint)",
        type = "integer",
        format = "int32",
        minimum = "1",
        maximum = "100"
    )
    private byte discountPercent;
    private int maxDiscountCost;
    private LocalDate expirationDate;
    
    public CouponSaveRequest(String userId, byte discountPercent, int maxDiscountCost, LocalDate expirationDate) {
        this.userId = userId;
        this.discountPercent = discountPercent;
        this.maxDiscountCost = maxDiscountCost;
        this.expirationDate = expirationDate;
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
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setDiscountPercent(byte discountPercent) {
        this.discountPercent = discountPercent;
    }
    public void setMaxDiscountCost(int maxDiscountCost) {
        this.maxDiscountCost = maxDiscountCost;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    
}
