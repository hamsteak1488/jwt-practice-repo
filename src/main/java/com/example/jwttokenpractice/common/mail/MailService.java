package com.example.jwttokenpractice.common.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

public interface MailService {
    MimeMessage createMessage(String recipientEmail) throws MessagingException, UnsupportedEncodingException;

    void sendMail(String recipientEmail) throws MessagingException, UnsupportedEncodingException;
}