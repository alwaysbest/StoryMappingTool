package nju.software.repo;

import nju.software.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Time       : 2019/1/9 12:40 AM
 * Author     : tangdaye
 * Description: 故事数据层单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class StoryRepoTest {
    @Resource
    StoryRepo storyRepo;

    @Test
    @Transactional
    public void test1() {
        assertNotNull(storyRepo.findStoriesByProjectId(1));
    }
}
