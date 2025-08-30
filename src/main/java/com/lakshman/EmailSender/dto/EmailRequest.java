package com.lakshman.EmailSender.dto;

import java.util.List;

public class EmailRequest {
    private List<String> toEmails;
    private String subject;
<<<<<<< HEAD
    private String body;
    private List<String> attachment;

    public EmailRequest(List<String> toEmails, String subject, String body, List<String> attachment) {
        this.toEmails = toEmails;
        this.subject = subject;
        this.body = body;
=======
//    private String body;
    private List<String> attachment;

    public EmailRequest(List<String> toEmails, String subject, List<String> attachment) {
        this.toEmails = toEmails;
        this.subject = subject;
//        this.body = body;
>>>>>>> EmailSender
        this.attachment = attachment;
    }

    public List<String> getToEmails() {
        return toEmails;
    }

    public void setToEmails(List<String> toEmails) {
        this.toEmails = toEmails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

<<<<<<< HEAD
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
=======
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
>>>>>>> EmailSender

    public List<String> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<String> attachment) {
        this.attachment = attachment;
    }
    @Override
    public String toString() {
        return "EmailRequest{" +
                "attachment='" + attachment + '\'' +
                ", toEmails=" + toEmails +
                ", subject='" + subject + '\'' +
<<<<<<< HEAD
                ", body='" + body + '\'' +
=======
//                ", body='" + body + '\'' +
>>>>>>> EmailSender
                '}';
    }
}
