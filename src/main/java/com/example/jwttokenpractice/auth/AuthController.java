package com.example.jwttokenpractice.auth;

import com.example.jwttokenpractice.common.mail.MailService;
import com.example.jwttokenpractice.jwt.Jwt;
import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    private final MailService mailService;

    @PostMapping("/login")
    public ResponseEntity<Jwt> login(SigninRequestDto signinRequestDto) {
        Jwt jwt = authService.signin(signinRequestDto);

        if (jwt == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @GetMapping("/mailtest")
    public void testMail() {
        try {
            mailService.sendMail("woals1488@naver.com");
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}