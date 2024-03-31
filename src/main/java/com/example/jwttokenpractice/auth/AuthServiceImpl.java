package com.example.jwttokenpractice.auth;

import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import com.example.jwttokenpractice.jwt.Jwt;
import com.example.jwttokenpractice.jwt.JwtProvider;
import com.example.jwttokenpractice.member.Member;
import com.example.jwttokenpractice.member.MemberRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;
    @Override
    public Jwt signin(SigninRequestDto signinRequestDto) {
        Member member = memberRepository.findMemberByUsername(signinRequestDto.getUsername());
        if (member == null) {
            // 전역 예외 처리
            return null;
        }
        if (!member.getPassword().equals(signinRequestDto.getPassword())) {
            // 전역 예외 처리
            return null;
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", member.getUsername());
        return jwtProvider.createJwt(claims);
    }
}
