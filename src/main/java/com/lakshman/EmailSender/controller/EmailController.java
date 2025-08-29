package com.lakshman.EmailSender.controller;

import com.lakshman.EmailSender.dto.EmailRequest;
import com.lakshman.EmailSender.service.EmailServiceImpl;
import com.lakshman.EmailSender.service.IEmailservice;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final IEmailservice emailService;
    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
        if (emailRequest == null || emailRequest.getBody() == null) {
            return ResponseEntity.badRequest().body("Invalid request body");
        }
            String response = emailService.sendEmail(emailRequest.getToEmails(),emailRequest.getSubject(),emailRequest.getBody(),emailRequest.getAttachment());
        return ResponseEntity.ok(response);
    }
}
