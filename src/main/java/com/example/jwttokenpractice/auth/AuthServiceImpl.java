package com.example.jwttokenpractice.auth;

import com.example.jwttokenpractice.auth.dto.RefreshTokenDto;
import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import com.example.jwttokenpractice.auth.dto.SignoutRequestDto;
import com.example.jwttokenpractice.common.exception.ErrorCode;
import com.example.jwttokenpractice.common.exception.JwtExceptionHandler;
import com.example.jwttokenpractice.common.exception.MemberExceptionHandler;
import com.example.jwttokenpractice.jwt.Jwt;
import com.example.jwttokenpractice.jwt.JwtProvider;
import com.example.jwttokenpractice.jwt.RefreshTokenManager;
import com.example.jwttokenpractice.member.Member;
import com.example.jwttokenpractice.member.MemberRepository;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;
    private final RefreshTokenManager refreshTokenManager;

    @Override
    public Jwt signin(SigninRequestDto signinRequestDto) {
        Member member = memberRepository.findMemberByUsername(signinRequestDto.getUsername())
                .orElseThrow(() -> new MemberExceptionHandler(ErrorCode.USERNAME_NOT_FOUND_ERROR));

        if (!member.checkUsernamePassword(signinRequestDto.getUsername(), signinRequestDto.getPassword())) {
            throw new MemberExceptionHandler(ErrorCode.PASSWORD_NOT_MATCH_ERROR);
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", member.getUsername());
        Jwt jwt = jwtProvider.createJwt(claims);

        refreshTokenManager.putRefreshToken(member.getUsername(), jwt.getRefreshToken());

        return jwtProvider.createJwt(claims);
    }

    @Override
    public boolean signout(SignoutRequestDto signoutRequestDto) {
        refreshTokenManager.removeRefreshToken(signoutRequestDto.getUsername());
        return true;
    }

    @Override
    public Jwt refreshToken(RefreshTokenDto refreshTokenDto) {
        String storedRefreshToken = refreshTokenManager.getRefreshToken(refreshTokenDto.getUsername());

        // TODO : storedRefreshToken null 예외 추가 할 것
        if (storedRefreshToken == null) return null;

        try {
            jwtProvider.getClaims(refreshTokenDto.getRefreshToken());
        } catch (ExpiredJwtException e) {
            throw new JwtExceptionHandler(ErrorCode.EXPIRED_REFRESH_TOKEN_EXCEPTION);
        }

        if (!storedRefreshToken.equals(refreshTokenDto.getRefreshToken())) {
            // TODO : refresh token 불일치 예외 추가 할 것
            return null;
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", refreshTokenDto.getUsername());
        Jwt jwt = jwtProvider.createJwt(claims);

        refreshTokenManager.putRefreshToken(refreshTokenDto.getUsername(), jwt.getRefreshToken());

        return jwtProvider.createJwt(claims);
    }
}
