package nju.software.entity;

import javax.persistence.*;

/**
 * Time       : 2019/1/8 10:37 PM
 * Author     : tangdaye
 * Description: 一级卡片实体类
 */
@Entity
@Table(name = "epic")
public class Epic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public Epic() {
    }

    public Epic(int projectId, String title, String description) {
        this.projectId = projectId;
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
        return "Epic{" +
                "id=" + id +
                ", projectId='" + projectId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
