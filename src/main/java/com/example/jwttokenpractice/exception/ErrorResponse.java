package com.example.jwttokenpractice.exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private int status;
    private String divisionCode;
    private String resultMsg;
    private List<FieldError> errors;
    private String reason;

    @Builder
    protected ErrorResponse(final ErrorCode code) {
        this.resultMsg = code.getMessage();
        this.status = code.getStatus();
        this.divisionCode = code.getDivisionCode();
        this.errors = new ArrayList<>();
    }

    @Builder
    protected ErrorResponse(final ErrorCode code, final String reason) {
        this.resultMsg = code.getMessage();
        this.status = code.getStatus();
        this.divisionCode = code.getDivisionCode();
        this.errors = new ArrayList<>();
    }

    public static ErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
        return new ErrorResponse(code, FieldError.of(bindingResult));
    }

    public static ErrorResponse of(final ErrorCode code) {
        return new ErrorResponse(code);
    }

    public static ErrorResponse of(final ErrorCode code, final String reason) {
        return new ErrorResponse(code, reason);
    }

    @Getter
    public static class FieldError {

    }
}
