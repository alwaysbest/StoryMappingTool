package nju.software.controller.request;

import lombok.*;

/**
 * Time       : 2019/1/12 11:35 PM
 * Author     : tangdaye
 * Description: /project request
 */
@Data
public class CreateProjectRequest {
    private int creatorId;
    private String title;
    private String description;
}
