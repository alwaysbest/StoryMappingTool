package nju.software.service.impl;

import nju.software.entity.*;
import nju.software.repo.*;
import nju.software.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogRepo logRepo;

    @Resource
    private ActivityRepo activityRepo;

    @Resource
    private EpicRepo epicRepo;

    @Resource
    private ReleaseRepo releaseRepo;

    @Resource
    private StoryRepo storyRepo;

    @Resource
    private ProjectRepo projectRepo;



    @Override
    public List<Log> findLogsByProject(int projectId) {
        if(projectId<=0){
            return new ArrayList<>();
        }
        return logRepo.findLogsByProjectIdOrderByTime(projectId);
    }

    @Override
    public void insertLog(int projectId, int operator, Item item, int itemId, String title, OperationType operationType) {
        Log log = new Log();
        log.setProjectId(projectId);
        log.setOperator(operator);
        log.setItem(item);
        log.setItemId(itemId);
        if(title == null && operationType.equals(OperationType.DELETE)){
            title = getTitle(item, itemId);
        }
        log.setOperationType(operationType);
        log.setTitle(title);
        log.setTime(new Date());
        logRepo.saveAndFlush(log);
    }

    private String getTitle(Item item, int itemId){
        String title = null;
        switch (item){
            case ACTIVITY:{
                Activity activity = activityRepo.getOne(itemId);
                if(activity!=null)
                    title = activity.getTitle();
            } break;
            case EPIC:{
                Epic epic = epicRepo.getOne(itemId);
                if(epic != null)
                    title = epic.getTitle();
            } break;
            case STORY:{
                Story story = storyRepo.getOne(itemId);
                if(story!=null){
                    title = story.getTitle();
                }
            }break;
            case SPRINT:{
                Release release = releaseRepo.getOne(itemId);
                if(release != null){
                    title = release.getTitle();
                }
            }break;
            case PROJECT:{
                Project project = projectRepo.getOne(itemId);
                if(project != null){
                    title = project.getTitle();
                }
            }break;
            case OTHER:
                title = "undefined";
        }
        return title;
    }
}
