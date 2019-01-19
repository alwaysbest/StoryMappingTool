package nju.software.controller.response;

import lombok.*;
import nju.software.entity.Epic;

/**
 * Time       : 2019/1/13 10:55 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/epic response
 */
@Data
public class CreateOrUpdateEpicResponse {
    private String status;

    private Epic epic;

}
