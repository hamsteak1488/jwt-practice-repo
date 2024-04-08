package com.example.jwttokenpractice.auth;

import com.example.jwttokenpractice.auth.dto.RefreshTokenDto;
import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import com.example.jwttokenpractice.auth.dto.SignoutRequestDto;
import com.example.jwttokenpractice.common.exception.ErrorCode;
import com.example.jwttokenpractice.common.exception.MemberExceptionHandler;
import com.example.jwttokenpractice.jwt.Jwt;
import com.example.jwttokenpractice.jwt.JwtProvider;
import com.example.jwttokenpractice.jwt.RefreshTokenManager;
import com.example.jwttokenpractice.member.Member;
import com.example.jwttokenpractice.member.MemberRepository;
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
        return jwtProvider.createJwt(claims);
    }

    @Override
    public boolean signout(SignoutRequestDto signoutRequestDto) {

        return false;
    }

    @Override
    public Jwt refreshToken(RefreshTokenDto refreshTokenDto) {
        return null;
    }
}
