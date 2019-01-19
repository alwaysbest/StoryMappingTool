package nju.software.controller.response;

import lombok.*;
import nju.software.entity.Activity;

/**
 * Time       : 2019/1/13 10:55 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/activity response
 */
@Data
public class CreateOrUpdateActivityResponse {
    private String status;

    private Activity activity;
}
