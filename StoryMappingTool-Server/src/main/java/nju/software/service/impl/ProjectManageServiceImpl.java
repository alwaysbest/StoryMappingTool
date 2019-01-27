package nju.software.service.impl;

import nju.software.entity.*;
import nju.software.repo.*;
import nju.software.service.ProjectManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Time       : 2019/1/12 11:07 PM
 * Author     : tangdaye
 * Description: 项目管理服务实现
 */
@Service
public class ProjectManageServiceImpl implements ProjectManageService {
    @Resource
    private UserRepo userRepo;
    @Resource
    private ProjectRepo projectRepo;
    @Resource
    private UserProjectRepo userProjectRepo;
    @Resource
    private ReleaseRepo releaseRepo;
    @Resource
    private EpicRepo epicRepo;
    @Resource
    private ActivityRepo activityRepo;
    @Resource
    private StoryRepo storyRepo;

    @Override
    public List<Project> getProjectsByUser(int userId) {
        return projectRepo.findProjectsByUserId(userId);
    }

    @Override
    public List<String[]> getMembersByProject(int projectId) {
        List<String[]> result = new ArrayList<>();
        List<User> usersDto = userRepo.findUsersByProjectId(projectId);
        for (User user : usersDto) {
            String[] temp = {user.getUsername(), user.getEmail()};
            result.add(temp);
        }
        return result;
    }

    @Override
    public List<Release> getReleasesByProject(int projectId) {
        return releaseRepo.findReleasesByProjectIdOrderBySequenceId(projectId);
    }

    @Override
    public List<Epic> getEpicsByProject(int projectId) {
        return epicRepo.findEpicsByProjectIdOrderBySequenceId(projectId);
    }

    @Override
    public List<Activity> getActivitiesByProject(int projectId) {
        return activityRepo.findActivitiesByProjectId(projectId);
    }

    @Override
    public List<Story> getStoriesByProject(int projectId) {
        return storyRepo.findStoriesByProjectId(projectId);
    }

    @Override
    public Project createProject(int creatorId, String title, String description) {
        // 保存一个project实例
        Project project = new Project(creatorId, title, description);
        Project projectDto = projectRepo.saveAndFlush(project);
        if (projectDto == null) {
            return null;
        }
        //保存一个关系实例
        UserProject userProject = new UserProject(creatorId, projectDto.getId());
        UserProject userProjectDto = userProjectRepo.saveAndFlush(userProject);
        return projectDto;
    }

    @Override
    public boolean existProject(int id) {
        return projectRepo.existsById(id);
    }

    @Override
    public boolean inviteMember(int projectId, String email) {
        User userDto = userRepo.findUserByEmail(email);
        if (userDto == null) {
            return false;
        }
        UserProject userProjectDto = userProjectRepo.findUserProjectByUserIdAndProjectId(userDto.getId(), projectId);
        if (userProjectDto != null) {
            return false;
        }
        UserProject userProject = new UserProject(userDto.getId(), projectId);
        userProjectRepo.saveAndFlush(userProject);
        return true;
    }

    @Override
    public Epic createEpic(int projectId, int sequenceId, String title, String description) {
        //todo: move epic after this
        Epic epic = new Epic(projectId, sequenceId, title, description);
        return epicRepo.saveAndFlush(epic);
    }

    @Override
    public Epic updateEpic(int id, int projectId, int sequenceId, String title, String description) {
        Optional<Epic> epicDtoOptional = epicRepo.findById(id);
        if (!epicDtoOptional.isPresent()) {
            return null;
        }
        Epic epicDto = epicDtoOptional.get();
        //todo: move epic after
        //todo: move epic before
        epicDto.setSequenceId(sequenceId);
        epicDto.setTitle(title);
        epicDto.setDescription(description);
        return epicRepo.saveAndFlush(epicDto);
    }

    @Override
    public Activity createActivity(int projectId, int epicId, int sequenceId, String title, String description) {
        //todo: move activity after this
        Activity activity = new Activity(projectId, epicId, sequenceId, title, description);
        return activityRepo.saveAndFlush(activity);
    }

    @Override
    public Activity updateActivity(int id, int projectId, int epicId, int sequenceId, String title, String description) {
        Optional<Activity> activityDtoOptional = activityRepo.findById(id);
        if (!activityDtoOptional.isPresent()) {
            return null;
        }
        Activity activityDto = activityDtoOptional.get();
        // todo move activity before
        // todo move activity after
        activityDto.setEpicId(epicId);
        activityDto.setSequenceId(sequenceId);
        activityDto.setTitle(title);
        activityDto.setDescription(description);
        return activityRepo.saveAndFlush(activityDto);
    }

    @Override
    public Release createRelease(int projectId, int sequenceId, String title, String description, Date start, Date end, Status status) {
        // todo move release after
        Release release = new Release(projectId, sequenceId, title, description, start, end, status);
        return releaseRepo.saveAndFlush(release);
    }

    @Override
    public Release updateRelease(int id, int projectId, int sequenceId, String title, String description, Date start, Date end, Status status) {
        Optional<Release> releaseDtoOptional = releaseRepo.findById(id);
        if (!releaseDtoOptional.isPresent()) {
            return null;
        }
        Release releaseDto = releaseDtoOptional.get();
        // todo move release before
        // todo move release after
        releaseDto.setSequenceId(sequenceId);
        releaseDto.setTitle(title);
        releaseDto.setDescription(description);
        releaseDto.setStart(start);
        releaseDto.setEnd(end);
        releaseDto.setStatus(status);
        return releaseRepo.saveAndFlush(releaseDto);
    }

    @Override
    public Story createStory(int projectId, int epicId, int activityId, int releaseId, int sequenceId,
                             String title, String description, int points, Date start, Date end, Status status) {
        // todo move story after
        Story story = new Story(projectId, epicId, activityId, releaseId, sequenceId, title, description, points, start, end, status);
        return storyRepo.saveAndFlush(story);
    }

    @Override
    public Story updateStory(int id, int projectId, int epicId, int activityId, int releaseId, int sequenceId,
                             String title, String description, int points, Date start, Date end, Status status) {

        Optional<Story> storyDtoOptional = storyRepo.findById(id);
        if (!storyDtoOptional.isPresent()) {
            return null;
        }
        Story storyDto = storyDtoOptional.get();
        // todo move story before
        // todo move story after
        storyDto.setEpicId(epicId);
        storyDto.setActivityId(activityId);
        storyDto.setReleaseId(releaseId);
        storyDto.setSequenceId(sequenceId);
        storyDto.setTitle(title);
        storyDto.setDescription(description);
        storyDto.setPoints(points);
        storyDto.setStart(start);
        storyDto.setEnd(end);
        storyDto.setStatus(status);
        return storyRepo.saveAndFlush(storyDto);
    }


}
