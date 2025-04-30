package com.taekyoungk.matching_service.common.exception.coupon;

import org.springframework.http.HttpStatus;

import com.taekyoungk.matching_service.common.exception.BusinessException;

public class CouponNotFoundException extends BusinessException {
    public CouponNotFoundException(String userId, int idx) {
        super(String.format("해당 쿠폰을 찾을 수 없습니다. 사용자/쿠폰번호: %s / %d", userId, idx));
    }
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}