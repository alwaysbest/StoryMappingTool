package nju.software.service;

import nju.software.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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

//    @Test
//    public void test1() {
//        String address = "tangdaye1996@hotmail.com";
//        String content = "ABCD";
//        String title = "Story Mapping Tool的验证码";
//        assertTrue(service.sendEmail(address, content, title));
//    }
}
