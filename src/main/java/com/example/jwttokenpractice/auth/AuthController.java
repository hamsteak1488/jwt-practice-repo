package com.example.jwttokenpractice.auth;

import com.example.jwttokenpractice.auth.dto.RefreshTokenDto;
import com.example.jwttokenpractice.auth.dto.LogoutRequestDto;
import com.example.jwttokenpractice.common.mail.MailService;
import com.example.jwttokenpractice.jwt.Jwt;
import com.example.jwttokenpractice.auth.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final MailService mailService;

    @PostMapping("/login")
    public ResponseEntity<Jwt> login(LoginRequestDto loginRequestDto) {

        return new ResponseEntity<>(
                authService.login(loginRequestDto),
                HttpStatus.OK
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout(LogoutRequestDto logoutRequestDto) {
        return new ResponseEntity<>(
                authService.logout(logoutRequestDto),
                HttpStatus.OK
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<Jwt> refreshToken(RefreshTokenDto refreshTokenDto) {
        return new ResponseEntity<>(
                authService.refreshToken(refreshTokenDto),
                HttpStatus.OK
        );
    }
}