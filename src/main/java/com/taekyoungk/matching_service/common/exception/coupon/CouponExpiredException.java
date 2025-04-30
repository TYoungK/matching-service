package com.taekyoungk.matching_service.common.exception.coupon;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import com.taekyoungk.matching_service.common.exception.BusinessException;

public class CouponExpiredException extends BusinessException{
    public CouponExpiredException(int idx, LocalDate expirationDate) {
        super(String.format("해당 쿠폰은 만료되었습니다. 쿠폰번호/만료일: %s / %s", idx, expirationDate.toString()));
    }
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
