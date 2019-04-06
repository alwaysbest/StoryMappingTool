package nju.software.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "operator")
    private int operator;

    @Column(name = "operation_type")
    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @Column(name = "item")
    @Enumerated(EnumType.STRING)
    private Item item;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "title")
    private String title;

    @Column(name = "time")
    private Date time;
}
