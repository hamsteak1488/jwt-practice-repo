package com.example.jwttokenpractice.jwt;

import org.springframework.stereotype.Component;

public interface RefreshTokenManager {
    void putRefreshToken(String username, String refreshToken);
    String getRefreshToken(String username);
    void removeRefreshToken(String username);
}