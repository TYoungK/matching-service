package com.taekyoungk.matching_service.domain.payments.dto;

public class TossPaymentsFailureResponse {
    String code;
    String message;
    public TossPaymentsFailureResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}
