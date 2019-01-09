package nju.software.repo;

import nju.software.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Time       : 2019/1/9 12:40 AM
 * Author     : tangdaye
 * Description: 故事数据层单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@TestPropertySource(locations = "classpath:application.properties")
public class StoryRepoTest {
    @Resource
    StoryRepo storyRepo;

    @Test
    public void testFindStoryById() {
        System.out.println(storyRepo.findStoryById(1));
    }
}
