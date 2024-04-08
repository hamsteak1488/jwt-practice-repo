package com.example.jwttokenpractice.jwt;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MemoryRefreshTokenManager implements RefreshTokenManager {
    HashMap<String, String> store = new HashMap<>();

    public void putRefreshToken(String username, String refreshToken) {
        store.put(username, refreshToken);
    }

    public String getRefreshToken(String username) {
        return store.get(username);
    }

    @Override
    public void removeRefreshToken(String username) {
        store.remove(username);
    }
}
