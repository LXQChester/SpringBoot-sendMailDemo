package com.example.demo.service;


import javax.mail.MessagingException;

public interface MailService {

    void sendSimpleMail(String to,String subject,String content);

    void sendHtmlMail(String to,String subject,String content) throws MessagingException;

    void sendAttachmentsMail(String to,String subject,String content,String filePath);
}
