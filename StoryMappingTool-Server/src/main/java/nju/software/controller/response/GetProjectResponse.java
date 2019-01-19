package nju.software.controller.response;

import lombok.*;
import nju.software.controller.vo.ActivityVO;
import nju.software.controller.vo.EpicVO;
import nju.software.entity.Activity;
import nju.software.entity.Epic;
import nju.software.entity.Release;
import nju.software.entity.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * Time       : 2019/1/13 3:40 PM
 * Author     : tangdaye
 * Description: /project/{id} response
 */
@Data
public class GetProjectResponse {
    private String status;
    private int id;
    private List<EpicVO> epicList;
    private List<Release> releaseList;
    private List<String[]> memberList;

    public GetProjectResponse() {
        this.epicList = new ArrayList<>();
    }

    public void setEpicList(List<Epic> epicList, List<Activity> activityList, List<Story> storyList) {
        for (Epic epic : epicList) {
            if (epic.getProjectId() == this.getId()) {
                EpicVO epicVO = new EpicVO();
                epicVO.setId(epic.getId());
                epicVO.setProjectId(epic.getProjectId());
                epicVO.setSequenceId(epic.getSequenceId());
                epicVO.setTitle(epic.getTitle());
                epicVO.setDescription(epic.getDescription());
                for (Activity activity : activityList) {
                    if (activity.getEpicId() == epic.getId()) {
                        ActivityVO activityVO = new ActivityVO();
                        activityVO.setId(activity.getId());
                        activityVO.setProjectId(activity.getProjectId());
                        activityVO.setEpicId(activity.getEpicId());
                        activityVO.setSequenceId(activity.getSequenceId());
                        activityVO.setTitle(activity.getTitle());
                        activityVO.setDescription(activity.getDescription());
                        for (Story story : storyList) {
                            if (story.getActivityId() == activityVO.getId()) {
                                activityVO.addStory(story);
                            }
                        }
                        epicVO.addActivity(activityVO);
                    }
                }
                this.addEpic(epicVO);
            }
        }

    }

    //按sequence id添加
    private void addEpic(EpicVO vo) {
        int j = 0;
        for (; j < this.epicList.size(); j++) {
            if (this.epicList.get(j).getSequenceId() > vo.getSequenceId()) {
                break;
            }
        }
        this.epicList.add(j, vo);
    }

}
