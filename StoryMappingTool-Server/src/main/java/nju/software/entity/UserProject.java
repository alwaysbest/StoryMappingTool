package nju.software.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * Time       : 2019/1/9 12:14 AM
 * Author     : tangdaye
 * Description: 用户和项目关系实体
 */
@Data
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


    public UserProject() {
    }

    public UserProject(int userId, int projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }
}
