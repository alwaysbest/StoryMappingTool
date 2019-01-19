package nju.software.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Time       : 2019/1/8 10:37 PM
 * Author     : tangdaye
 * Description: 一级卡片实体类
 */
@Data
@Entity
@Table(name = "epic")
public class Epic {
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

    public Epic() {
    }

    public Epic(int projectId, int sequenceId, String title, String description) {
        this.projectId = projectId;
        this.sequenceId = sequenceId;
        this.title = title;
        this.description = description;
    }
}
