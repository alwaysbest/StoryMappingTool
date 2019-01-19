package nju.software.service;

import nju.software.App;
import nju.software.entity.Status;
import nju.software.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


import java.util.Date;

import static org.junit.Assert.*;

/**
 * Time       : 2019/1/14 10:54 PM
 * Author     : tangdaye
 * Description: 项目管理服务测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ProjectManageServiceTest {
    @Resource
    ProjectManageService service;

    @Test
    @Transactional
    public void test1() {
        assertEquals(2, service.getProjectsByUser(2).size());
    }

    @Test
    @Transactional
    public void test2() {
        assertEquals(1, service.getMembersByProject(2).size());
    }

    @Test
    @Transactional
    public void test3() {
        assertEquals(0, service.getReleasesByProject(2).size());
    }

    @Test
    @Transactional
    public void test4() {
        assertEquals(2, service.getEpicsByProject(1).size());
    }

    @Test
    @Transactional
    public void test5() {
        assertEquals(2, service.getActivitiesByProject(1).size());
    }

    @Test
    @Transactional
    public void test6() {
        assertEquals(1, service.getStoriesByProject(1).size());
    }

    @Test
    @Transactional
    public void test7() {
        int creatorId = 1;
        String title = "test project title";
        String description = "test project description";
        service.createProject(creatorId, title, description);
        assertEquals(3, service.getProjectsByUser(1).size());
    }

    @Test
    @Transactional
    public void test8() {
        assertTrue(!service.existProject(4));
    }

    @Test
    @Transactional
    public void test9() {
        assertTrue(!service.inviteMember(1, "dsdsd"));
        assertTrue(!service.inviteMember(2, "MF1832144@smail.nju.edu.cn"));
        assertTrue(service.inviteMember(2, "tdy_nju@163.com"));
        assertEquals(2, service.getMembersByProject(2).size());
    }

    @Test
    @Transactional
    public void test10() {
        int projectId = 1;
        int sequenceId = 3;
        String title = "test epic title";
        String description = "test epic description";
        assertNotNull(service.createEpic(projectId, sequenceId, title, description));
        assertEquals(3, service.getEpicsByProject(1).size());
    }

    @Test
//    @Transactional
    public void test11() {
        int id = 5;
        int projectId = 3;
        int sequenceId = 1;
        String title = "test epic title";
        String description = "test epic description";
        assertNotNull(service.updateEpic(id, projectId, sequenceId, title, description));
        assertEquals("test epic description", service.getEpicsByProject(3).get(0).getDescription());
    }

    @Test
    @Transactional
    public void test12() {
        int projectId = 1;
        int epicId = 1;
        int sequenceId = 3;
        String title = "test activity title";
        String description = "test activity description";
        assertNotNull(service.createActivity(projectId, epicId, sequenceId, title, description));
        assertEquals(3, service.getActivitiesByProject(1).size());
    }

    @Test
    @Transactional
    public void test13() {
        int id = 2;
        int projectId = 1;
        int epicId = 1;
        int sequenceId = 3;
        String title = "test activity title";
        String description = "test activity description";
        assertNotNull(service.updateActivity(id, projectId, epicId, sequenceId, title, description));
        assertEquals("test activity title", service.getActivitiesByProject(1).get(0).getTitle());
    }

    @Test
    @Transactional
    public void test14() {
        int projectId = 1;
        int sequenceId = 2;
        String title = "test release title";
        String description = "test release description";
        Date start = StringUtil.string2Date("20190101");
        Date end = StringUtil.string2Date("20180301");
        Status status = Status.DOING;
        assertNotNull(service.createRelease(projectId, sequenceId, title, description, start, end, status));
        assertEquals(2, service.getReleasesByProject(1).size());
    }

    @Test
    @Transactional
    public void test15() {
        int id = 1;
        int projectId = 1;
        int sequenceId = 1;
        String title = "test release title";
        String description = "test release description";
        Date start = StringUtil.string2Date("20190101");
        Date end = StringUtil.string2Date("20180301");
        Status status = Status.DOING;
        assertNotNull(service.updateRelease(id, projectId, sequenceId, title, description, start, end, status));
        assertEquals(Status.DOING, service.getReleasesByProject(1).get(0).getStatus());
    }

    @Test
    @Transactional
    public void test16() {
        int projectId = 1;
        int epicId = 1;
        int activityId = 2;
        int releaseId = 1;
        int sequenceId = 2;
        String title = "test story title";
        String description = "test story description";
        int points = 10;
        Date start = StringUtil.string2Date("20190101");
        Date end = StringUtil.string2Date("20180301");
        Status status = Status.DOING;
        assertNotNull(service.createStory(projectId, epicId, activityId, releaseId, sequenceId, title, description, points, start, end, status));
        assertEquals(2, service.getStoriesByProject(1).size());
    }

    @Test
    @Transactional
    public void test17() {
        int id = 1;
        int projectId = 1;
        int epicId = 1;
        int activityId = 2;
        int releaseId = 1;
        int sequenceId = 2;
        String title = "test story title";
        String description = "test story description";
        int points = 10;
        Date start = StringUtil.string2Date("20190101");
        Date end = StringUtil.string2Date("20190301");
        Status status = Status.DOING;
        assertNotNull(service.updateStory(id, projectId, epicId, activityId, releaseId, sequenceId, title, description, points, start, end, status));
        assertEquals(StringUtil.string2Date("20190101"), service.getStoriesByProject(1).get(0).getStart());
    }


}
