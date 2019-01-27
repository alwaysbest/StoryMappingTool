package nju.software.controller.request;

import lombok.*;

/**
 * Time       : 2019/1/14 3:42 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/release request
 */
@Data
public class CreateOrUpdateReleaseRequest {
    private int id;
    private int creatorId;
    private int sequenceId;
    private String title;
    private String description;
    private String start;
    private String end;
    private int status;

}
