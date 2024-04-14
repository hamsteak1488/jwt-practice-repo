package com.example.jwttokenpractice.jwt;

import org.springframework.stereotype.Component;

public interface RefreshTokenManager {
    void putRefreshToken(String username, String uuid);
    String getRefreshToken(String username);
    void removeRefreshToken(String username);
}