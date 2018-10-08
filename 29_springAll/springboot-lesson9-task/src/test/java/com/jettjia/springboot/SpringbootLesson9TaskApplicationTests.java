package com.jettjia.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLesson9TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知");
        message.setText("今晚开会");
        message.setTo("jettjia@foxmail.com");
        message.setFrom("928721730@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test02() throws  Exception{
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);

        helper.setTo("jettjia@foxmail.com");
        helper.setFrom("928721730@qq.com");

        //上传文件
        helper.addAttachment("aa.jpg",new File("C:\\Users\\ThinkPad\\Pictures\\IQIYISnapShot\\aa.jpg"));
        helper.addAttachment("11.jpg",new File("C:\\Users\\ThinkPad\\Pictures\\IQIYISnapShot\\11.jpg"));

        mailSender.send(mimeMessage);

    }

}
