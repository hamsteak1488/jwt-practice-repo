package com.example.jwttokenpractice.auth;

import com.example.jwttokenpractice.jwt.Jwt;
import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
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

    @PostMapping("/signin")
    public ResponseEntity<Jwt> signin(SigninRequestDto signinRequestDto) {
        Jwt jwt = authService.signin(signinRequestDto);

        if (jwt == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
}