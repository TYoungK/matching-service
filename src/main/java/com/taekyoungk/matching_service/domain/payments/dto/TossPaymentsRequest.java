package com.taekyoungk.matching_service.domain.payments.dto;

import java.util.Optional;

public class TossPaymentsRequest {
    private String userId;
    private Optional<Integer> couponIdx;
    private String paymentKey;
    private String orderId;
    private int amount;

    public TossPaymentsRequest(String userId, Optional<Integer> couponIdx, String paymentKey, String orderId, int amount) {
        this.userId = userId;
        this.couponIdx = couponIdx;
        this.paymentKey = paymentKey;
        this.orderId = orderId;
        this.amount = amount;
    }
    public String getPaymentKey() {
        return paymentKey;
    }
    public String getOrderId() {
        return orderId;
    }
    public int getAmount() {
        return amount;
    }
    public String getUserId() {
        return userId;
    }
    public Optional<Integer> getCouponIdx() {
        return couponIdx;
    }

}
