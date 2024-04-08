package com.example.jwttokenpractice.auth;

import com.example.jwttokenpractice.auth.dto.RefreshTokenDto;
import com.example.jwttokenpractice.auth.dto.SignoutRequestDto;
import com.example.jwttokenpractice.common.mail.MailService;
import com.example.jwttokenpractice.jwt.Jwt;
import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
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
    public ResponseEntity<Jwt> login(SigninRequestDto signinRequestDto) {

        return new ResponseEntity<>(
                authService.signin(signinRequestDto),
                HttpStatus.OK
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout(SignoutRequestDto signoutRequestDto) {
        return new ResponseEntity<>(
                authService.signout(signoutRequestDto),
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