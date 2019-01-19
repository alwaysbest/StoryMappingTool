package nju.software.repo;

import nju.software.App;
import nju.software.entity.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Time       : 2019/1/15 2:50 PM
 * Author     : tangdaye
 * Description: 活动数据层测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ActivityRepoTest {
    @Resource
    ActivityRepo repo;

    @Test
    @Transactional
    public void test1() {
        List<Activity> activityList = repo.findActivitiesByProjectId(1);
        assertNotNull(activityList);
    }


}
