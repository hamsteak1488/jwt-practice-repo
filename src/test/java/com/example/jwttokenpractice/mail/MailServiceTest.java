package com.example.jwttokenpractice.mail;

import com.example.jwttokenpractice.common.mail.MailService;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
public class MailServiceTest {
    private final MailService mailService;

    @Autowired
    public MailServiceTest(MailService mailService) {
        this.mailService = mailService;
    }

    @Test
    @DisplayName("메일 전송 테스트")
    public void testMailSender() {
        try {
            mailService.sendMail("woals1488@naver.com");
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
