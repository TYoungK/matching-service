package com.taekyoungk.matching_service.domain.coupon.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taekyoungk.matching_service.common.exception.coupon.CouponExpiredException;
import com.taekyoungk.matching_service.common.exception.coupon.CouponNotFoundException;
import com.taekyoungk.matching_service.common.exception.user.UserNotFoundException;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponDto;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponListResponse;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponSaveRequest;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponValidationRequest;
import com.taekyoungk.matching_service.domain.coupon.entity.Coupon;
import com.taekyoungk.matching_service.domain.coupon.repository.CouponRepository;
import com.taekyoungk.matching_service.domain.user.entity.User;
import com.taekyoungk.matching_service.domain.user.repository.UserRepository;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public CouponDto create(CouponSaveRequest couponSaveRequest){
        User user = userRepository.findById(couponSaveRequest.getUserId()).orElseThrow(() -> new UserNotFoundException(couponSaveRequest.getUserId()));
        Coupon coupon = couponRepository.save(new Coupon(user, couponSaveRequest.getDiscountPercent(), couponSaveRequest.getMaxDiscountCost(), couponSaveRequest.getExpirationDate()));
        return new CouponDto(coupon.getIdx(), coupon.getUser().getId(), coupon.getDiscountPercent(), coupon.getMaxDiscountCost(), coupon.getExpirationDate());
    }

    @Transactional
    public CouponListResponse getCouponsByUserId(String userId){
        List<CouponDto> couponDtos = couponRepository.findAllByUser_Id(userId).stream().map(coupon -> new CouponDto(coupon.getIdx(), coupon.getUser().getId(), coupon.getDiscountPercent(), coupon.getMaxDiscountCost(), coupon.getExpirationDate())).toList();
        return new CouponListResponse(couponDtos);
    }

    @Transactional
    public boolean validate(CouponValidationRequest couponValidationRequest){
        Coupon coupon = couponRepository.findById(couponValidationRequest.getCouponIdx()).orElseThrow(
            () -> new CouponNotFoundException(couponValidationRequest.getUserId(), couponValidationRequest.getCouponIdx()));
        if (!coupon.getUser().getId().equals(couponValidationRequest.getUserId())){
            throw new CouponNotFoundException(couponValidationRequest.getUserId(), couponValidationRequest.getCouponIdx());
        }
        if (coupon.getExpirationDate().isBefore(LocalDate.now())){
            throw new CouponExpiredException(couponValidationRequest.getCouponIdx(), coupon.getExpirationDate());
        }
        return true;
    }

    @Transactional
    public boolean delete(int couponId){
        couponRepository.deleteById(couponId);
        return true;
    }
}
