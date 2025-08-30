package com.lakshman.EmailSender.service;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.List;
@Service
public class EmailServiceImpl implements IEmailservice{
    private final JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;


    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public String sendEmail(List<String> toEmails, String subject, List<String> attachment) {
        try{
            for (String to : toEmails){
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
                helper.addTo(to);
                helper.setSubject(subject);

                Context context = new Context();
//                context.setVariable("name",name);
                // Generate the HTML content from Thymeleaf template
                String body = templateEngine.process("emailTemplet.html",context);

                helper.setText(body,true);

                for (String attach : attachment){
                    File fileObj = new File(attach);
                    if(!fileObj.exists()){
                        logger.info("File Doesn't Exists {}", fileObj.getName());
                        return "File Doesn't Exist";
                    }
                    if (!fileObj.getName().toLowerCase().endsWith(".pdf")) {
                        logger.info("Invalid File Type {}", fileObj.getName());
                        return "Invalid File Type: " + fileObj.getName();
                    }
                    // Validate file size (less than 5MB)
                    long fileSizeInBytes = fileObj.length();
                    if (fileSizeInBytes > 5 * 1024 * 1024) {
                        logger.info("File Too Large {}", fileObj.getName());
                        return "File Too Large: " + fileObj.getName();
                    }
                    FileSystemResource file = new FileSystemResource(fileObj);
                    helper.addAttachment(fileObj.getName(), file);
                }
                mailSender.send(mimeMessage);
            }


            logger.info("Email Sent to : {}",toEmails.toString());
        return "Email Sent!";
        } catch (Exception e) {
            logger.warn("Failed to send {}",e.getMessage());
            return "Failed to Send :- "+e.getMessage();
        }
    }
}
