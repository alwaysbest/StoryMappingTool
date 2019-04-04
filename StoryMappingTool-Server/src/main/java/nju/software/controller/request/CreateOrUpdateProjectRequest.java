package nju.software.controller.request;

import lombok.*;

/**
 * Time       : 2019/1/12 11:35 PM
 * Author     : tangdaye
 * Description: /project request
 */
@Data
public class CreateOrUpdateProjectRequest {
    private int creatorId;
    private int projectId;
    private String title;
    private String description;
}
