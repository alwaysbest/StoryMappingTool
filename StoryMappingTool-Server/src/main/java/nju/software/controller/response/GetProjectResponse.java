package nju.software.controller.response;

import nju.software.entity.Activity;
import nju.software.entity.Epic;
import nju.software.entity.Release;
import nju.software.entity.Story;

import java.util.List;

/**
 * Time       : 2019/1/13 3:40 PM
 * Author     : tangdaye
 * Description: /project/{id} response
 */
public class GetProjectResponse {
    // todo 结构化 1月14日晚
    private String status;
    private int id;
    private List<Epic> epicList;
    private List<Activity> activityList;
    private List<Story> storyList;
    private List<Release> releaseList;
    private List<String[]> memberList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Epic> getEpicList() {
        return epicList;
    }

    public void setEpicList(List<Epic> epicList) {
        this.epicList = epicList;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    public List<Release> getReleaseList() {
        return releaseList;
    }

    public void setReleaseList(List<Release> releaseList) {
        this.releaseList = releaseList;
    }

    public List<String[]> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String[]> memberList) {
        this.memberList = memberList;
    }
}
