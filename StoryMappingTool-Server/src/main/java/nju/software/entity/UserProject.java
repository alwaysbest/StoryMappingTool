package nju.software.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Time       : 2019/1/9 12:14 AM
 * Author     : tangdaye
 * Description: 用户和项目关系实体
 */
@Entity
@Table(name = "user_project")
public class UserProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "project_id")
    private int projectId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProject that = (UserProject) o;
        return id == that.id &&
                userId == that.userId &&
                projectId == that.projectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, projectId);
    }

    public UserProject() {
    }

    public UserProject(int userId, int projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }
}
