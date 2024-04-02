package com.example.jwttokenpractice.jwt;

import com.example.jwttokenpractice.auth.RSAKeyManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.security.Keys;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    // 대칭 키 생성에 사용될 내용
    public static final byte[] secret = "jm_secret_key12345678901234567890".getBytes();

    // HMAC-SHA 알고리즘
    private final Key hmacShaKey = Keys.hmacShaKeyFor(secret);

    private final RSAKeyManager rsaKeyManager;
    private final RefreshTokenManager refreshTokenRepository;

    public Jwt createJwt(Map<String, Object> claims) {
        String accessToken = createToken(claims, getExpireDateAccessToken());
        String refreshToken = createToken(new HashMap<>(), getExpireDateRefreshToken());

        refreshTokenRepository.putRefreshToken(accessToken, refreshToken);

        return Jwt.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public String createToken(Map<String, Object> claims, Date expireDate) {
        PrivateKey privateKey = rsaKeyManager.loadPrivateKey();
        return Jwts.builder()
                .claims(claims)
                .expiration(expireDate)
                .signWith(privateKey)
                .compact();
    }

    public Claims getClaims(String token) {
        PublicKey publicKey = rsaKeyManager.loadPublicKey();
        return (Claims) Jwts.parser()
                .verifyWith(publicKey)
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