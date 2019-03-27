package com.example.demo.Service;

import com.example.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail(){
        mailService.sendSimpleMail("***@163.com","这是第一封邮件","大家好，这是我第一封SpringBoot发送的邮件！");
    }


    @Test
    public void sendHtmlMail() throws MessagingException {
        String content = "<html>\n"+
                "<body>\n"+
                "<h3 style=\"color:#FF0000\"> hello world , 这是一封HTML邮件 </h3>"+
                "</body>\n"+
                "</html>";
        mailService.sendHtmlMail("***@163.com","这是一封HTML邮件",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath = "/data/181205.zip";

        mailService.sendAttachmentsMail("***@163.com","这是一封带附件的邮箱","你好Sunny,这是SpringBoot发送的一封邮件，请记得下载附件",filePath);
    }

    @Test
    public void testTmeplatemMailTest() throws MessagingException {
        Context context = new Context();
        context.setVariable("id","006");

        String emailContent = templateEngine.process("emailTemplate",context);
        mailService.sendHtmlMail("***@163.com","这是一个模版邮件",emailContent);
    }

}
