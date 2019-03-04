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

    public CreateOrUpdateStoryRequest() {
    }

    public CreateOrUpdateStoryRequest(int id, int epicId, int activityId, int releaseId, int creatorId, int sequenceId, String title, String description, String start, String end, int points, int status) {
        this.id = id;
        this.epicId = epicId;
        this.activityId = activityId;
        this.releaseId = releaseId;
        this.creatorId = creatorId;
        this.sequenceId = sequenceId;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.points = points;
        this.status = status;
    }
}
