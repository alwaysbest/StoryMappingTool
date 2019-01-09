package nju.software.entity;

import javax.persistence.*;
import java.sql.Date;
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

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "points")
    private Integer points;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StoryStatus status;

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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
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


    public StoryStatus getStatus() {
        return status;
    }

    public void setStatus(StoryStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return id == story.id &&
                projectId == story.projectId &&
                epicId == story.epicId &&
                activityId == story.activityId &&
                releaseId == story.releaseId &&
                Objects.equals(title, story.title) &&
                Objects.equals(description, story.description) &&
                Objects.equals(points, story.points) &&
                Objects.equals(start, story.start) &&
                Objects.equals(end, story.end) &&
                Objects.equals(status, story.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, epicId, activityId, releaseId, title, description, points, start, end, status);
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", epicId=" + epicId +
                ", activityId=" + activityId +
                ", releaseId=" + releaseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", points=" + points +
                ", start=" + start +
                ", end=" + end +
                ", status=" + status +
                '}';
    }

    public Story() {
    }

    public Story(int projectId, int epicId, int activityId, int releaseId, String title, String description, Integer points, Date start, Date end, StoryStatus status) {
        this.projectId = projectId;
        this.epicId = epicId;
        this.activityId = activityId;
        this.releaseId = releaseId;
        this.title = title;
        this.description = description;
        this.points = points;
        this.start = start;
        this.end = end;
        this.status = status;
    }
}
