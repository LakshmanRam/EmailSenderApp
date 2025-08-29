package com.lakshman.EmailSender.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
@Service
public class EmailServiceImpl implements IEmailservice{

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public String sendEmail(List<String> toEmails, String subject, String body, List<String> attachment) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            for (String to : toEmails){
                helper.addTo(to);
            }
            helper.setSubject(subject);
            helper.setText(body);
            for (String attach : attachment){
                File fileObj = new File(attach);
                if(!fileObj.exists()){
                    return "File Doesn't Exist";
                }
                FileSystemResource file = new FileSystemResource(fileObj);
                helper.addAttachment(fileObj.getName(), file);
            }
            mailSender.send(mimeMessage);
        return "Email Sent!";
        } catch (Exception e) {
            return "Failed to Send :- "+e.getMessage();
        }
    }
}
