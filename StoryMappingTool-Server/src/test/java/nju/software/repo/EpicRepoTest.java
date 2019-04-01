package nju.software.repo;

import nju.software.App;
import nju.software.entity.Epic;
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
public class EpicRepoTest {
    @Resource
    EpicRepo repo;

    @Test
    @Transactional
    public void test1() {
        assertNotNull(repo.findEpicsByProjectIdOrderBySequenceId(1));
        assertNotNull( repo.findEpicsByProjectIdOrderBySequenceId(2));
        assertNotNull(repo.findEpicsByProjectIdOrderBySequenceId(3));
    }

    @Test
    @Transactional
    public void test2() {
        int id = 2;
        int projectId = 1;
        int sequenceId = 3;
        String title = "test epic title2";
        String description = "test epic description2";
        Epic epic = new Epic(projectId, sequenceId, title, description);
        epic.setId(id);
        Epic dto = repo.saveAndFlush(epic);
        System.out.println(dto);
    }

    @Test
    @Transactional
    public void test3(){
        int proId = 1;
        int sequenceId = 4;
        List<Epic> list = repo.findEpicsByProjectIdAndSequenceIdAfter(proId, sequenceId);
        System.out.println(list.size());
    }
}
