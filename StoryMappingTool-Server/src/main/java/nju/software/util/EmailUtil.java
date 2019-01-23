package nju.software.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileOutputStream;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Time       : 2019/1/9 9:49 PM
 * Author     : tangdaye
 * Description: 邮件工具类
 */
public class EmailUtil {

    public static boolean sendEmail(String address, String title, String content) {
        Properties props = new Properties();
        props.setProperty("mail.debug", "true");
        props.setProperty("mail.smtp.auth", "true");
        props.put("mail.smtp.port", 465);
        String host = "smtp.qq.com";
        System.out.println(host);
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.transport.protocol", "smtp");
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
            Session session = Session.getInstance(props);
            Message msg = new MimeMessage(session);
            msg.setSubject(title);
            msg.setSentDate(new Date());
            msg.setText("\n验证码: " + content);
            String account = "1138833148@qq.com";
            msg.setFrom(new InternetAddress(account, "Story Mapping Tool", "UTF-8"));
            Transport transport = session.getTransport();
            String password = "erhfoiapfzgqgbdd";
            transport.connect(host, account, password);
            transport.sendMessage(msg, new Address[]{new InternetAddress(address)});
            transport.close();
        } catch (GeneralSecurityException | MessagingException | UnsupportedEncodingException e) {
            return false;
//            e.printStackTrace();
        }
        return true;


    }
}