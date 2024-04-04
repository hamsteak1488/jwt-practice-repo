package com.example.jwttokenpractice.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public class ApiError {
    String code;
    int status;
    String name,
    String message,
    @JsonInclude(Include)
}
