package nju.software.controller.vo;

import nju.software.entity.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * Time       : 2019/1/14 9:55 PM
 * Author     : tangdaye
 * Description: ActivityVO 用于返回展示所需的结构化数据
 */
public class ActivityVO {
    private int id;
    private int projectId;
    private int epicId;
    private int sequenceId;
    private String title;
    private String description;

    private List<Story> storyList;

    public ActivityVO() {
        this.storyList = new ArrayList<>();
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

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
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

    public List<Story> getStoryList() {
        return storyList;
    }

    //按sequence id添加
    public void addStory(Story vo) {
        int j = 0;
        for (; j < this.storyList.size(); j++) {
            if (this.storyList.get(j).getSequenceId() > vo.getSequenceId()) {
                break;
            }
        }
        this.storyList.add(j, vo);
    }
}
