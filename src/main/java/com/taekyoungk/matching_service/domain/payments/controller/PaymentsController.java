package com.taekyoungk.matching_service.domain.payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taekyoungk.matching_service.domain.payments.dto.TossPaymentsRequest;
import com.taekyoungk.matching_service.domain.payments.dto.TossPaymentsSuccessResponse;
import com.taekyoungk.matching_service.domain.payments.service.PaymentsService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/payments")
public class PaymentsController {
    @Autowired
    PaymentsService paymentsService;

    @PostMapping("/toss/confirm")
    public ResponseEntity<TossPaymentsSuccessResponse> postMethodName(TossPaymentsRequest tossPaymentsRequest) {
        TossPaymentsSuccessResponse response = paymentsService.tossPaymentsConfirm(tossPaymentsRequest);
        return ResponseEntity.ok(response);
    }
    
}
