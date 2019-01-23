package nju.software.service.impl;

import nju.software.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Time       : 2019/1/23 10:50 PM
 * Author     : tangdaye
 * Description: 邮件服务实现
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public boolean sendEmail(String address, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(address);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
        return true;
    }
}
