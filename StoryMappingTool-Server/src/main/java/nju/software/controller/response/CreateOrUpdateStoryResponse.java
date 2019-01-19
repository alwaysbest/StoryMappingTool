package nju.software.controller.response;

import lombok.*;
import nju.software.entity.Story;

/**
 * Time       : 2019/1/14 3:42 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/story response
 */
@Data
public class CreateOrUpdateStoryResponse {
    private String status;

    private Story story;

}
