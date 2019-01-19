package nju.software.controller.request;


import lombok.*;

/**
 * Time       : 2019/1/13 10:55 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/activity request
 */
@Data
public class CreateOrUpdateActivityRequest {
    private int id;
    private int epicId;
    private int creatorId;
    private int sequenceId;
    private String title;
    private String description;
}
