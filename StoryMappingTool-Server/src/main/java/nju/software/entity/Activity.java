package nju.software.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Time       : 2019/1/8 10:30 PM
 * Author     : tangdaye
 * Description: 二级卡片实体类
 */
@Data
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "sequence_id")
    private int sequenceId;

    @Column(name = "epic_id")
    private int epicId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public Activity() {
    }

    public Activity(int projectId, int epicId, int sequenceId, String title, String description) {
        this.projectId = projectId;
        this.epicId = epicId;
        this.sequenceId = sequenceId;
        this.title = title;
        this.description = description;
    }

}
