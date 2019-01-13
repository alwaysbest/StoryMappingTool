package nju.software.entity;

import javax.persistence.*;

/**
 * Time       : 2019/1/8 8:55 PM
 * Author     : tangdaye
 * Description: 项目实体类
 */
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "creator_id")
    private String createId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public Project() {
    }

    public Project(String createId, String title, String description) {
        this.createId = createId;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
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
}
