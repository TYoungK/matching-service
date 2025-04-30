package com.taekyoungk.matching_service.common.exception.user;

import org.springframework.http.HttpStatus;

import com.taekyoungk.matching_service.common.exception.BusinessException;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException(String id) {
        super("사용자를 찾을 수 없습니다. ID: " + id);
    }
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}