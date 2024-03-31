package com.example.jwttokenpractice;

import com.example.jwttokenpractice.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class JwtTokenPracticeApplication {
	public static void main(String[] args) {
		SpringApplication.run(JwtTokenPracticeApplication.class, args);
	}

}
