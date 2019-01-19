package nju.software.controller.response;

import lombok.*;
import nju.software.entity.Project;

/**
 * Time       : 2019/1/12 11:37 PM
 * Author     : tangdaye
 * Description: /project response
 */
@Data
public class CreateProjectResponse {
    private String status;

    private Project project;

}
