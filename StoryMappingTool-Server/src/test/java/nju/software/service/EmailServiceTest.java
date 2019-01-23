package nju.software.service;

import nju.software.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Time       : 2019/1/23 7:18 PM
 * Author     : tangdaye
 * Description: 邮件工具类测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class EmailServiceTest {
    @Resource
    EmailService service;

    @Test
    public void test1() {
        Properties prop = System.getProperties();
        System.getProperties().put("proxySet","true");
        // 设置http访问要使用的代理服务器的地址
        prop.setProperty("http.proxyHost","219.219.113.223");
        // 设置http访问要使用的代理服务器的端口
        prop.setProperty("http.proxyPort","81");
        String address = "tangdaye1996@hotmail.com";
        String content = "ABCD";
        String title = "Story Mapping Tool的验证码";
        assertTrue(service.sendEmail(address, title, content));
    }
}
