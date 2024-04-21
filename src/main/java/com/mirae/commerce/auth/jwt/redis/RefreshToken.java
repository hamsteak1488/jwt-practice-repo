package com.mirae.commerce.auth.jwt.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash(value = "refreshToken", timeToLive = 60)
@AllArgsConstructor
@ToString
public class RefreshToken {

    @Id
    private String username;

    private String refreshToken;
}