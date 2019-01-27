package nju.software.controller.request;

import lombok.*;

/**
 * Time       : 2019/1/13 10:55 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/epic request
 */
@Data
public class CreateOrUpdateEpicRequest {
    private int id;
    private int creatorId;
    private int sequenceId;
    private String title;
    private String description;
}
