package com.example.jwttokenpractice.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    DEFAULT("멤버 서비스 도중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String MESSAGE;
    private final HttpStatus STATUS;

    @Override
    public HttpStatus defaultHttpStatus() {
        return STATUS;
    }

    @Override
    public String defaultMessage() {
        return MESSAGE;
    }

    @Override
    public RuntimeException defaultException() {
        return new MemberException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return new MemberException(this, cause);
    }
}
