package nju.software.controller.vo;

import lombok.*;
import nju.software.entity.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * Time       : 2019/1/14 9:55 PM
 * Author     : tangdaye
 * Description: ActivityVO 用于返回展示所需的结构化数据
 */
@Data
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
