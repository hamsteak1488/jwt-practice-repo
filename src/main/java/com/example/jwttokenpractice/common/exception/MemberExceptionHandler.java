package com.example.jwttokenpractice.common.exception;

import lombok.Builder;
import lombok.Getter;

public class MemberExceptionHandler extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;

    @Builder
    public MemberExceptionHandler(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    @Builder
    public MemberExceptionHandler(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
