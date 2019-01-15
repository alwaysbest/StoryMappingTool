package nju.software.controller.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Time       : 2019/1/14 9:48 PM
 * Author     : tangdaye
 * Description: EpicVO 用于返回展示所需的结构化数据
 */
public class EpicVO {
    private int id;
    private int projectId;
    private int sequenceId;
    private String title;
    private String description;
    private List<ActivityVO> activityList;

    public EpicVO() {
        this.activityList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ActivityVO> getActivityList() {
        return activityList;
    }

    //按sequence id添加
    public void addActivity(ActivityVO vo) {
        int j = 0;
        for (; j < this.activityList.size(); j++) {
            if (this.activityList.get(j).getSequenceId() > vo.getSequenceId()) {
                break;
            }
        }
        this.activityList.add(j, vo);
    }
}
