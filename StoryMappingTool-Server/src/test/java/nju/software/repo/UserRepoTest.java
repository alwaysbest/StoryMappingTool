package nju.software.repo;

import nju.software.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Time       : 2019/1/8 8:12 PM
 * Author     : tangdaye
 * Description: UserDao的单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@TestPropertySource(locations = "classpath:application.properties")
public class UserRepoTest {
    @Resource
    UserRepo userRepo;

    @Test
    public void testFindByEmail(){
        System.out.println(userRepo.findUserByEmail("MF1832144@smail.nju.edu.cn"));
    }
}
