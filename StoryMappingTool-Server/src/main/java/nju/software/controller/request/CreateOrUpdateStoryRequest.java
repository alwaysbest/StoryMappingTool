package nju.software.controller.request;

import lombok.*;

/**
 * Time       : 2019/1/14 3:42 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/story request
 */
@Data
public class CreateOrUpdateStoryRequest {
    private int id;
    private int epicId;
    private int activityId;
    private int releaseId;
    private int creatorId;
    private int sequenceId;
    private String title;
    private String description;
    private String start;
    private String end;
    private int points;
    private int status;
}
