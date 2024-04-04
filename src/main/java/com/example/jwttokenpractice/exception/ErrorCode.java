package com.example.jwttokenpractice.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    private final int status;
    private final String divisionCode;
    private final String message;

    ErrorCode(int status, String divisionCode, String message) {
        this.status = status;
        this.divisionCode = divisionCode;
        this.message = message;
    }
}
