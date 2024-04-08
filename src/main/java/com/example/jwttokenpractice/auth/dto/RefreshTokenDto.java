package com.example.jwttokenpractice.auth.dto;

import com.example.jwttokenpractice.jwt.Jwt;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RefreshTokenDto {
    private String username;
    private String refreshToken;
}
