package com.example.jwttokenpractice.auth;

import com.example.jwttokenpractice.auth.dto.RefreshTokenDto;
import com.example.jwttokenpractice.auth.dto.LoginRequestDto;
import com.example.jwttokenpractice.auth.dto.LogoutRequestDto;
import com.example.jwttokenpractice.jwt.Jwt;

public interface AuthService {
    Jwt login(LoginRequestDto loginRequestDto);
    boolean logout(LogoutRequestDto logoutRequestDto);

    Jwt refreshToken(RefreshTokenDto refreshTokenDto);
}
