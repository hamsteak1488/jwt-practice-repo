package com.example.jwttokenpractice.common.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;

public interface MailService {
    MimeMessage createMessage(String recipientEmail, String title, String htmlContent) throws MessagingException, UnsupportedEncodingException;

    void sendMail(MimeMessage message);
}