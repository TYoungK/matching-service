package com.taekyoungk.matching_service.domain.payments.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.taekyoungk.matching_service.common.exception.payments.TossPaymentsException;
import com.taekyoungk.matching_service.domain.coupon.dto.CouponValidationRequest;
import com.taekyoungk.matching_service.domain.coupon.service.CouponService;
import com.taekyoungk.matching_service.domain.payments.dto.TossPaymentsRequest;
import com.taekyoungk.matching_service.domain.payments.dto.TossPaymentsSuccessResponse;
import com.taekyoungk.matching_service.domain.user.service.UserService;


@Service
public class PaymentsService {
    @Autowired
    private CouponService couponService;
    @Autowired
    private UserService userService;

    private final String TOSS_PAYMENTS_CONFIRM_URL = "https://api.tosspayments.com/v1/payments/confirm";

    @Transactional
    public TossPaymentsSuccessResponse tossPaymentsConfirm(TossPaymentsRequest tossPaymentsRequest){
        RestTemplate restTemplate = new RestTemplate();
        String requestBody = String.format(
            "{\"paymentKey\":\"%s\",\"orderId\":\"%s\",\"amount\":%d}",
            tossPaymentsRequest.getPaymentKey(), tossPaymentsRequest.getOrderId(), tossPaymentsRequest.getAmount()
        );
        HttpHeaders headers = new HttpHeaders();
        String encodedKey = new String(Base64.getEncoder().encode(("test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6" + ":").getBytes()));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(encodedKey);
        
        TossPaymentsSuccessResponse result = null;
        try {
            result = restTemplate.postForObject(TOSS_PAYMENTS_CONFIRM_URL,
            new HttpEntity<>(requestBody, headers), TossPaymentsSuccessResponse.class);
            userService.chargePoint(tossPaymentsRequest.getUserId(), result.getTotalAmount());
            if (!tossPaymentsRequest.getCouponIdx().isEmpty()){
                couponService.delete(tossPaymentsRequest.getCouponIdx().get());
            }
        } catch (Exception e) {
            throw new TossPaymentsException(e.getMessage());
        }

        return result;
    }
}
