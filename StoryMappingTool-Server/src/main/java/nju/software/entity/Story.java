package nju.software.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Time       : 2019/1/9 12:14 AM
 * Author     : tangdaye
 * Description: 三级故事实体类
 */
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

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

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
