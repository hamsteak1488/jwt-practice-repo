package com.example.jwttokenpractice.auth.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SigninRequestDto {
    private String username;
    private String password;
}
