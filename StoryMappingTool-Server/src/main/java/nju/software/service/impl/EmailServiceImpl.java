package nju.software.service.impl;

import nju.software.service.EmailService;
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

    public boolean sendEmail(String address, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1138833148@qq.com");
        message.setTo(address);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
        return true;
    }
}
