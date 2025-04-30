package com.taekyoungk.matching_service.common.exception.payments;

import org.springframework.http.HttpStatus;

import com.taekyoungk.matching_service.common.exception.BusinessException;

public class TossPaymentsException extends BusinessException{
    public TossPaymentsException(String message){
        super(message);
    }
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
