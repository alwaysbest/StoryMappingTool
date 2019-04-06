package nju.software.service;

import nju.software.entity.*;

import java.util.Date;
import java.util.List;

/**
 * Time       : 2019/1/12 11:06 PM
 * Author     : tangdaye
 * Description: 项目管理服务类
 */
public interface ProjectManageService {
    List<Project> getProjectsByUser(int userId);

    List<String[]> getMembersByProject(int projectId);

    List<Release> getReleasesByProject(int projectId);

    List<Epic> getEpicsByProject(int projectId);

    List<Activity> getActivitiesByProject(int projectId);

    List<Story> getStoriesByProject(int projectId);

    Project createProject(int creatorId, String title, String description);

    Project updateProject(int projectId,String title,String description);

    boolean existProject(int id);

    boolean inviteMember(int projectId, String email);

    boolean removeMember(int projectId, String email);

    Epic createEpic(int projectId, int sequenceId, String title, String description);

    Epic updateEpic(int id, int projectId, int sequenceId, String title, String description);

    Activity createActivity(int projectId, int epicId, int sequenceId, String title, String description);

    Activity updateActivity(int id, int projectId, int epicId, int sequenceId, String title, String description);

    Release createRelease(int projectId, int sequenceId, String title, String description,
                          Date start, Date end, Status status);

    Release updateRelease(int id, int projectId, int sequenceId, String title, String description,
                          Date start, Date end, Status status);

    Story createStory(int projectId, int epicId, int activityId, int releaseId, int sequenceId,
                      String title, String description, int points, Date start, Date end, Status status);

    Story updateStory(int id, int projectId, int epicId, int activityId, int releaseId, int sequenceId,
                      String title, String description, int points, Date start, Date end, Status status);
}
