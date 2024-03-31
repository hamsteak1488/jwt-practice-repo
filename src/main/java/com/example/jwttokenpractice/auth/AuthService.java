package com.example.jwttokenpractice.auth;

import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import com.example.jwttokenpractice.jwt.Jwt;

public interface AuthService {
    Jwt signin(SigninRequestDto signinRequestDto);
}
