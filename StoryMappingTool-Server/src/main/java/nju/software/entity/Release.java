package nju.software.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Time       : 2019/1/8 10:39 PM
 * Author     : tangdaye
 * Description: 迭代周期实体类
 */
@Data
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

}
