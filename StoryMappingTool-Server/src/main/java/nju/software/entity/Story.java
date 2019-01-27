package nju.software.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Time       : 2019/1/9 12:14 AM
 * Author     : tangdaye
 * Description: 三级故事实体类
 */
@Data
@Entity
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "epic_id")
    private int epicId;

    @Column(name = "activity_id")
    private int activityId;

    @Column(name = "release_id")
    private int releaseId;

    @Column(name = "sequence_id")
    private int sequenceId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "points")
    private int points;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Story(int projectId, int epicId, int activityId, int releaseId, int sequenceId, String title, String description, int points, Date start, Date end, Status status) {
        this.projectId = projectId;
        this.epicId = epicId;
        this.activityId = activityId;
        this.releaseId = releaseId;
        this.sequenceId = sequenceId;
        this.title = title;
        this.description = description;
        this.points = points;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public Story() {
    }
}
