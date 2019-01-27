package nju.software.controller.vo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Time       : 2019/1/14 9:48 PM
 * Author     : tangdaye
 * Description: EpicVO 用于返回展示所需的结构化数据
 */
@Data
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
