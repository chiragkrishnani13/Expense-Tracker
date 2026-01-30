package com.sgt.ExpenseTracker.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class EmailServiceTest {
    @Autowired
    JavaMailSender mailSender;

    @Test
    void sendEmail() {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message);
        String htmlContent = """
        <h2>Welcome to Expense Tracker</h2>
        <p>Your account has been created successfully.</p>
        <b>Thank you!</b>
    """;

        try{
            messageHelper.setTo("chiragkrishnani13@gmail.com");
            messageHelper.setText(htmlContent,true);
            messageHelper.setSubject("Reset password - Expense Tracker");
            mailSender.send(message);
        }
        catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }
}