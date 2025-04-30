package com.taekyoungk.matching_service.domain.coupon.dto;

import java.util.List;

public class CouponListResponse {
    private List<CouponDto> coupons;

    public CouponListResponse(List<CouponDto> coupons) {
        this.coupons = coupons;
    }

    public List<CouponDto> getCoupons() {
        return coupons;
    }

}
