package nju.software.repo;

import nju.software.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Time       : 2019/1/15 2:50 PM
 * Author     : tangdaye
 * Description: 活动数据层测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ReleaseRepoTest {
    @Resource
    ReleaseRepo repo;

    @Test
    @Transactional
    public void test1() {
        assertNotNull(repo.findReleasesByProjectIdOrderBySequenceId(1));
    }
}
