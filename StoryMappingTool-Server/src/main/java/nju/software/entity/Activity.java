package nju.software.entity;

import javax.persistence.*;

/**
 * Time       : 2019/1/8 10:30 PM
 * Author     : tangdaye
 * Description: 二级卡片实体类
 */
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

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
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

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", sequenceId=" + sequenceId +
                ", epicId=" + epicId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
