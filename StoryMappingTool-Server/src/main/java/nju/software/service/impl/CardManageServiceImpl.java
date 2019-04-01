package nju.software.service.impl;

import nju.software.entity.*;
import nju.software.repo.*;
import nju.software.service.CardManageService;
import nju.software.service.ProjectManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardManageServiceImpl implements CardManageService {


    @Resource
    private EpicRepo epicRepo;

    @Resource
    private ActivityRepo  activityRepo;

    @Resource
    private StoryRepo storyRepo;

    @Resource
    private ReleaseRepo releaseRepo;

    @Resource
    private LogRepo logRepo;

    @Override
    public Epic insertEpic(int projectId, int sequenceId, String title, String description) {
        //首先把该project的所有epic调出来，然后调整被插入的位置之后的所有epic的sequence id
        Epic epic = new Epic(projectId, sequenceId+1, title, description);
        List<Epic> list = epicRepo.findEpicsByProjectIdAndSequenceIdAfter(projectId, sequenceId);
        for(Epic epic_tmp : list){
            epic_tmp.setSequenceId(epic_tmp.getSequenceId()+1);
            epicRepo.saveAndFlush(epic_tmp);
        }
        Epic result = epicRepo.saveAndFlush(epic);
        return result;
    }

    @Override
    public Activity insertActivity(int projectId, int epicId, int sequenceId, String title, String description) {
        Activity activity = new Activity(projectId, epicId, sequenceId+1, title, description);
        List<Activity> activityList = activityRepo.findActivitiesByProjectIdAndEpicIdAndSequenceIdAfter(projectId, epicId, sequenceId);
        for(Activity activity_tmp : activityList) {
            activity_tmp.setSequenceId(activity_tmp.getSequenceId()+1);
            activityRepo.save(activity_tmp);
        }
        Activity result = activityRepo.saveAndFlush(activity);
        return result;
    }

    @Override
    public Story insertStory(int projectId, int epicId, int activityId, int releaseId,
                             int sequenceId, String title, String description, int points,
                             Date start, Date end, Status status) {
        Story story = new Story(projectId, epicId, activityId, releaseId,
                sequenceId+1, title, description, points, start, end, status);
        List<Story> storyList = storyRepo.findStoriesByProjectIdAndEpicIdAndActivityIdAndSequenceIdAfter(
                projectId, epicId, activityId, sequenceId);
        for(Story story_tmp : storyList){
            story_tmp.setSequenceId(story_tmp.getSequenceId()+1);
            storyRepo.save(story_tmp);
        }
        Story result = storyRepo.saveAndFlush(story);
        return result;
    }

    @Override
    public Release insertRelease(int projectId, int sequenceId, String title,
                                 String description, Date start, Date end, Status status) {
        Release release = new Release(projectId, sequenceId+1, title,
                description, start, end, status);
        List<Release> releaseList = releaseRepo.findReleasesByProjectIdAndSequenceIdAfter(projectId, sequenceId);
        for (Release release_tmp : releaseList){
            release_tmp.setSequenceId(release_tmp.getSequenceId()+1);
        }
        releaseRepo.saveAll(releaseList);
        return releaseRepo.saveAndFlush(release);
    }

    @Override
    @Transactional
    public Boolean deleteEpic(int epicId) {
        // 删除时不仅要删除该epic卡片，还要删除该epic对应的所有activity, story卡片，以及调整该epic后续的epic的sequence
        Optional<Epic> epic = epicRepo.findById(epicId);
        if(epic.isPresent()){
            Epic realEpic = epic.get();
            int projectId = realEpic.getProjectId();
            int sequenceId = realEpic.getSequenceId();
            List<Epic> epicList = epicRepo.findEpicsByProjectIdAndSequenceIdAfter(projectId, sequenceId);
            for(Epic epic_tmp : epicList){
                epic_tmp.setSequenceId(epic_tmp.getSequenceId() - 1);
            }
            epicRepo.saveAll(epicList);
            epicRepo.delete(realEpic);
            epicRepo.flush();
            List<Activity> toDeleteActivityList = activityRepo.findActivitiesByEpicIdOrderBySequenceId(epicId);
            for(Activity activity_tmp : toDeleteActivityList){
                int activityId = activity_tmp.getId();
                storyRepo.deleteStoriesByActivityId(activityId);
            }
            activityRepo.deleteAll(toDeleteActivityList);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean deleteActivity(int activityId) {
        Optional<Activity> activityOptional = activityRepo.findById(activityId);
        if(activityOptional.isPresent()){
            Activity activity = activityOptional.get();
            int projectId = activity.getProjectId();
            int epicId = activity.getEpicId();
            int sequenceId = activity.getSequenceId();
            List<Activity> activityList = activityRepo.findActivitiesByProjectIdAndEpicIdAndSequenceIdAfter(projectId, epicId,  sequenceId);
            for(Activity activity_tmp : activityList){
                activity_tmp.setSequenceId(activity_tmp.getSequenceId()-1);
            }
            activityRepo.saveAll(activityList);
            activityRepo.delete(activity);
            activityRepo.flush();
            storyRepo.deleteStoriesByActivityId(activityId);
            storyRepo.flush();
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean deleteStory(int storyId) {
        // 删除story 并删除后续的story序列
        Optional<Story> storyOptional = storyRepo.findById(storyId);
        if(storyOptional.isPresent()){
            Story story = storyOptional.get();
            int projectId = story.getProjectId();
            int activityId = story.getActivityId();
            int epicId = story.getEpicId();
            int sequenceId = story.getSequenceId();
            List<Story> storyList = storyRepo.findStoriesByProjectIdAndEpicIdAndActivityIdAndSequenceIdAfter(
                    projectId, epicId, activityId, sequenceId);
            for(Story story_tmp : storyList){
                story_tmp.setSequenceId(story_tmp.getSequenceId()-1);
            }
            storyRepo.saveAll(storyList);
            storyRepo.delete(story);
            storyRepo.flush();
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean deleteRelease(int releaseId) {
        // 需要删除release记录，并且删除release中的所有的story，并顺移后续的story sequenceID, 顺移后续的release
        Optional<Release> releaseOptional = releaseRepo.findById(releaseId);
        if(releaseOptional.isPresent()){
            Release release = releaseOptional.get();
            int sequenceId = release.getSequenceId();
            int projectId = release.getProjectId();
            List<Release> releaseList = releaseRepo.findReleasesByProjectIdAndSequenceIdAfter(projectId, sequenceId);
            for(Release release_tmp : releaseList){
                release_tmp.setSequenceId(release_tmp.getSequenceId()-1);
            }
            releaseRepo.saveAll(releaseList);
            List<Story> storyList = storyRepo.findStoriesByReleaseId(releaseId);
            for (Story story_tmp : storyList){
                if(!deleteStory(story_tmp.getId())){
                    return false;
                }
            }
            releaseRepo.delete(release);
            releaseRepo.flush();
            return true;
        }
        return false;
    }


}
