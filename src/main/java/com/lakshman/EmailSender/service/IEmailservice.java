package com.lakshman.EmailSender.service;

import java.util.List;

public interface IEmailservice {
    String sendEmail(List<String> toEmails, String subject, List<String> attachment);
//    String sendEmail(List<String> toEmails, String subject, String body, List<String> attachment);

//    String sendEmail(String toEmails, String subject, String body, String attachment)

}
