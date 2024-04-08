package com.example.jwttokenpractice.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    // Member Service Error
    USERNAME_NOT_FOUND_ERROR(400, "M001", "username not found"),
    PASSWORD_NOT_MATCH_ERROR(400, "M002", "password not match"),

    // Global Error
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