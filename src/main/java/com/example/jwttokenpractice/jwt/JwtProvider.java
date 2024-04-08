package com.example.jwttokenpractice.jwt;

import com.example.jwttokenpractice.auth.RSAKeyManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
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
    private final RSAKeyManager rsaKeyManager;
    private final RefreshTokenManager refreshTokenRepository;

    private static final long ACCESS_TOKEN_EXPIRE_TIME_MILS = 1000 * 60 * 30;
    private static final long REFRESH_TOKEN_EXPIRE_TIME_MILS = 1000 * 60 * 60;

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
        try {
            return (Claims) Jwts.parser()
                    .verifyWith(publicKey)
                    .build()
                    .parse(token)
                    .getPayload();

        } catch (ExpiredJwtException e) {

        } catch (MalformedJwtException e) {

        } catch (Exception e) {

        }

        return null;
    }

    public Date getExpireDateAccessToken() {
        return new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRE_TIME_MILS);
    }
    public Date getExpireDateRefreshToken() {
        return new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRE_TIME_MILS);
    }
}