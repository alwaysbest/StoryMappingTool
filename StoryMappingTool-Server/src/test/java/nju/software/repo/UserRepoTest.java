package nju.software.repo;

import nju.software.App;
import nju.software.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Time       : 2019/1/8 8:12 PM
 * Author     : tangdaye
 * Description: UserDao的单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
//@TestPropertySource(locations = "classpath:application.properties")
public class UserRepoTest {
    @Resource
    UserRepo repo;

    @Test
    @Transactional
    public void test1() {
        assertNotNull(repo.findUserByEmail("MF1832144@smail.nju.edu.cn"));
    }

    @Test
    @Transactional
    public void test2() {
        assertNotNull(repo.findUserByEmailAndPasswd("MF1832144@smail.nju.edu.cn",
                "a448410bdcbb4d7cfb32830909f6aa08").getUsername());
    }

    @Test
    @Transactional
    public void test3() {
        User userDto = repo.findUserByEmail("MF1832144@smail.nju.edu.cn");
        assertNotNull(userDto);
        userDto.setUsername("世界");
        User user = repo.saveAndFlush(userDto);
        assertNotNull(user.getUsername());
    }
}
