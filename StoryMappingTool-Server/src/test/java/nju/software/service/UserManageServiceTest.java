package nju.software.service;

import static org.junit.Assert.*;

import nju.software.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Time       : 2019/1/9 9:21 PM
 * Author     : tangdaye
 * Description: 用户管理服务测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UserManageServiceTest {
    @Resource
    UserManageService service;

    @Test
    @Transactional
    public void test1() {
        assertTrue(service.existUser("MF1832144@smail.nju.edu.cn"));// 验证码为null，标明已验证
        assertTrue(service.existUser("tdy_nju@163.com"));//验证码不为null，标明已验证
    }

    @Test
    @Transactional
    public void test2() {
        assertEquals("你好", service.validateUser("MF1832144@smail.nju.edu.cn", "123456").getUsername());
    }

    @Test
    @Transactional
    public void test3() {
//        assertTrue(service.generateVerificationCode("tangdaye1996@hotmail.com"));//新的邮箱，可以生成验证码
//        assertTrue(!service.generateVerificationCode("tdy_nju@163.com"));//已经验证过的邮箱，不能生成验证码
//        assertTrue(!service.generateVerificationCode("MF1832144@smail.nju.edu.cn"));//已经验证过的邮箱，不能生成验证码
    }

    @Test
    @Transactional
    public void test4() {
//        assertTrue(!service.register("tangdaye", "tdy_nju@163.com", "123456", "1a2b"));//验证码不正确
//        assertTrue(!service.register("tangdaye", "tdy_nju@163.com", "123456", "1A2B"));//验证码正确
        assertTrue(service.register("lereina","1063162676@qq.com","123456","ABCD"));
    }
}
