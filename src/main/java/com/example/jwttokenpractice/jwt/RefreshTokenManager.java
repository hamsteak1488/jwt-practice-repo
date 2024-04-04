package com.example.jwttokenpractice.jwt;

import org.springframework.stereotype.Component;

public interface RefreshTokenManager {
    void putRefreshToken(String accessToken, String refreshToken);
    String getRefreshToken(String accessToken);
}