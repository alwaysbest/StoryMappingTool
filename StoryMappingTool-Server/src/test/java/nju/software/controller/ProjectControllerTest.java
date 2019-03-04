package nju.software.controller;

import nju.software.App;
import nju.software.controller.request.CreateOrUpdateStoryRequest;
import nju.software.controller.response.CreateOrUpdateStoryResponse;
import nju.software.controller.response.GetProjectResponse;
import nju.software.entity.Status;
import nju.software.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Time       : 2019/1/15 4:01 PM
 * Author     : tangdaye
 * Description: 项目管理控制器测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ProjectControllerTest {
    @Resource
    ProjectController controller;

    //就测试一个方法……
    @Test
    public void test1() {
        GetProjectResponse response = controller.getProject("1");
        System.out.println(response);
    }

    @Test
    public void test2() {
        int projectId = 1;
        int epicId = 1;
        int activityId = 2;
        int releaseId = 1;
        int sequenceId = 2;
        String title = "test story title0302";
        String description = "test story description0302";
        int points = 10;
        String start = "20190101";
        String end = "20180301";
//        this.id = id;
//        this.epicId = epicId;
//        this.activityId = activityId;
//        this.releaseId = releaseId;
//        this.creatorId = creatorId;
//        this.sequenceId = sequenceId;
//        this.title = title;
//        this.description = description;
//        this.start = start;
//        this.end = end;
//        this.points = points;
//        this.status = status;
        CreateOrUpdateStoryRequest request = new CreateOrUpdateStoryRequest(
                0, epicId, activityId, releaseId, 1, sequenceId, title, description, start, end, points, 1
        );
        controller.createOrUpdateStory("1", request);

    }
}
