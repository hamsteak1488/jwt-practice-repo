package com.example.jwttokenpractice.common.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JwtExceptionHandler extends RuntimeException {
    private final ErrorCode errorCode;

    @Builder
    public JwtExceptionHandler(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    @Builder
    public JwtExceptionHandler(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
