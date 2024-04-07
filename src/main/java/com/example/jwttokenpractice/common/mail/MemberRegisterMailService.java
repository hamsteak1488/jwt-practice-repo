package com.example.jwttokenpractice.common.mail;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Component
@RequiredArgsConstructor
public class MemberRegisterMailService implements MailService {
    private final JavaMailSender javaMailSender;
    @Override
    public MimeMessage createMessage(String recipientEmail) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();

        message.addRecipients(Message.RecipientType.TO, recipientEmail);
        message.setSubject("[Mirae] 메일 전송 테스트");

        StringBuilder sb = new StringBuilder();
        sb.append("<h1> h1태그 </h1>");
        sb.append("<br>");
        sb.append("asdf");

        message.setText(sb.toString(), "utf-8", "html");

        message.setFrom(new InternetAddress("ssafywoals@gmail.com", "Mirae Mail Sender"));

        return message;
    }

    @Override
    public void sendMail(String recipientEmail) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = createMessage(recipientEmail);

        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
