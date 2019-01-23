package nju.software.service;

/**
 * Time       : 2019/1/23 10:50 PM
 * Author     : tangdaye
 * Description: 邮件发送服务
 */
public interface EmailService {
    boolean sendEmail(String address, String title, String content);
}
