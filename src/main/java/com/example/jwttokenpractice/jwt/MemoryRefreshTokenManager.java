package com.example.jwttokenpractice.jwt;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MemoryRefreshTokenManager implements RefreshTokenManager {
    HashMap<String, String> store = new HashMap<>();

    public void putRefreshToken(String accessToken, String refreshToken) {
        store.put(accessToken, refreshToken);
    }

    public String getRefreshToken(String accessToken) {
        return store.get(accessToken);
    }
}
