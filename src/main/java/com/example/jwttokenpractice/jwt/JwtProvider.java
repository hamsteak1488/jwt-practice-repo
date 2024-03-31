package com.example.jwttokenpractice.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SecretKeyAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Component
public class JwtProvider {
    // 대칭 키 생성에 사용될 내용
    public static final byte[] secret = "jm_secret_key12345678901234567890".getBytes();

    // HMAC-SHA 알고리즘
    private final Key key = Keys.hmacShaKeyFor(secret);

    public Jwt createJwt(Map<String, Object> claims) {
        String accessToken = createToken(claims, getExpireDateAccessToken());
        String refreshToken = createToken(new HashMap<>(), getExpireDateRefreshToken());
        return Jwt.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public String createToken(Map<String, Object> claims, Date expireDate) {
        return Jwts.builder()
                .claims(claims)
                .expiration(expireDate)
                .signWith(key)
                .compact();
    }

    public Claims getClaims(String token) {
        return (Claims) Jwts.parser()
                .verifyWith((SecretKey) key)
                .build()
                .parse(token)
                .getPayload();
    }

    public Date getExpireDateAccessToken() {
        // 1시간
        long expireTimeMils = 1000 * 60 * 60;
        return new Date(System.currentTimeMillis() + expireTimeMils);
    }
    public Date getExpireDateRefreshToken() {
        // 60일
        long expireTimeMils = 1000L * 60 * 60 * 24 * 60;
        return new Date(System.currentTimeMillis() + expireTimeMils);
    }
}