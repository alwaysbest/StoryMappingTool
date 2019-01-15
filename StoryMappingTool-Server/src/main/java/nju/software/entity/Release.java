package nju.software.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Time       : 2019/1/8 10:39 PM
 * Author     : tangdaye
 * Description: 迭代周期实体类
 */
@Entity
@Table(name = "sprint")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "sequence_id")
    private int sequenceId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Release() {
    }

    public Release(int projectId, int sequenceId, String title, String description, Date start, Date end, Status status) {
        this.projectId = projectId;
        this.sequenceId = sequenceId;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Release{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", sequenceId=" + sequenceId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", status=" + status +
                '}';
    }
}
