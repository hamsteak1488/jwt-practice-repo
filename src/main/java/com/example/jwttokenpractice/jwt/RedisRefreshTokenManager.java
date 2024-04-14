/*
package com.example.jwttokenpractice.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisRefreshTokenManager implements RefreshTokenManager {
    private RedisRefreshTokenRepository redisRefreshTokenRepository;

    @Override
    public void putRefreshToken(String username, String uuid) {
        redisRefreshTokenRepository.save(new RefreshToken(uuid, username));
    }

    @Override
    public String getRefreshToken(String username) {
        return redisRefreshTokenRepository.findById(username).get().getRefreshToken();
    }

    @Override
    public void removeRefreshToken(String username) {
        redisRefreshTokenRepository.deleteById(username);
    }
}
*/