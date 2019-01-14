package nju.software.repo;

import nju.software.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import javax.annotation.Resource;

/**
 * Time       : 2019/1/13 5:37 PM
 * Author     : tangdaye
 * Description: 项目数据层单元测试
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ProjectRepoTest {
    @Resource
    ProjectRepo repo;

    @Test
    @Transactional
    public void test1() {
        assertEquals(1, repo.findProjectsByUserId(1).size());
        assertEquals("xixixi", repo.findProjectsByUserId(1).get(0).getTitle());
    }

}
