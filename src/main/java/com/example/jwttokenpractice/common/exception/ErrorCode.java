package com.example.jwttokenpractice.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    NULL_POINTER_ERROR(500, "G001", "Null Pointer Exception"),
    INTERNAL_SERVER_ERROR(500, "G999", "Internal Server Error Exception");

    private final int status;
    private final String divisionCode;
    private final String message;

    ErrorCode(final int status, final String divisionCode, final String message) {
        this.status = status;
        this.divisionCode = divisionCode;
        this.message = message;
    }

}