package com.example.jwttokenpractice.jwt;

import java.util.HashMap;

public class MemoryRefreshTokenManager {
    HashMap<String, String> store = new HashMap<>();

    void putRefreshToken(String accessToken, String refreshToken) {
        store.put(accessToken, refreshToken);
    }

    String getRefreshToken(String accessToken) {
        return store.get(accessToken);
    }
}
