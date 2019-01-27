package nju.software.controller.response;

import lombok.*;
import nju.software.entity.Project;

import java.util.List;

/**
 * Time       : 2019/1/12 11:27 PM
 * Author     : tangdaye
 * Description: /project response
 */
@Data
public class GetProjectByUserResponse {
    private String status;
    private List<Project> projectList;
}
