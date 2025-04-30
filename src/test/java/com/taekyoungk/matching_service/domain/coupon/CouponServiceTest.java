package com.taekyoungk.matching_service.domain.coupon;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.taekyoungk.matching_service.common.exception.coupon.CouponNotFoundException;
import com.taekyoungk.matching_service.common.exception.user.UserNotFoundException;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponDto;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponSaveRequest;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponValidationRequest;
import com.taekyoungk.matching_service.domain.coupon.service.CouponService;
import com.taekyoungk.matching_service.domain.user.dto.UserSaveRequest;
import com.taekyoungk.matching_service.domain.user.service.UserService;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class CouponServiceTest {
    
    @Autowired
    private UserService userService;

    @Autowired
    private CouponService couponService;

    @BeforeEach
    void setUp() {
        userService.create(new UserSaveRequest("test9999", "테스트9999", "1111"));
    }

    @Test
    void createTest(){
        CouponSaveRequest couponSaveRequest = new CouponSaveRequest("test", (byte) 20, 3000, LocalDate.now().plusDays(60));
        assertThrows(UserNotFoundException.class, () -> {
            couponService.create(couponSaveRequest);
        });
        couponSaveRequest.setUserId("test9999");
        CouponDto couponDto = couponService.create(couponSaveRequest);
        assertTrue(couponService.getCouponsByUserId(couponSaveRequest.getUserId()).getCoupons().size() > 0);
        assertTrue(couponDto.getIdx() > 0);
    }

    @Test
    void validateTest(){
        CouponSaveRequest couponSaveRequest = new CouponSaveRequest("test9999", (byte) 20, 3000, LocalDate.now().minusDays(1));
        int couponIdx = couponService.create(couponSaveRequest).getIdx();
        assertThrows(CouponNotFoundException.class, () -> {
            couponService.validate(new CouponValidationRequest("test", couponIdx));
            couponService.validate(new CouponValidationRequest("test9999", 0));
            couponService.validate(new CouponValidationRequest("test9999", couponIdx));
        });
        couponSaveRequest.setExpirationDate(LocalDate.now());
        int couponIdx2 = couponService.create(couponSaveRequest).getIdx();
        assertTrue(couponService.validate(new CouponValidationRequest("test9999", couponIdx2)));
        couponSaveRequest.setExpirationDate(LocalDate.now().plusDays(1));
        int couponIdx3 = couponService.create(couponSaveRequest).getIdx();
        assertTrue(couponService.validate(new CouponValidationRequest("test9999", couponIdx3)));
    }
}
