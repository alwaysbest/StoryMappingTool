package nju.software.service;

import nju.software.App;
import nju.software.entity.Activity;
import nju.software.entity.Epic;
import nju.software.entity.Status;
import nju.software.entity.Story;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class CardManageServiceTest {

    @Resource
    CardManageService cardManageService;

    @Test
    public void insertEpic() {
//        Epic epic = new Epic();
        Epic epic = cardManageService.insertEpic(1, 4, "测试1", "插入测试");
        System.out.println(epic.getTitle() + ":" + epic.getId());
    }

    @Test
    public void insertActivity() {
        Activity a = cardManageService.insertActivity(33, 72, 1, "测试插入活动", "测试插入");
        System.out.println(a.getId()+ ":" + a.getTitle());
    }

    @Test
    public void insertStory() {
        Story story = cardManageService.insertStory(44, 87, 67, 43, 1, "测试插入", "ceshi",
                12, new Date(), new Date(), Status.DONE);
        System.out.println(story.getId() + ":" + story.getTitle());
    }
}