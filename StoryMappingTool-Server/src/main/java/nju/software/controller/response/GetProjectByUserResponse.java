package nju.software.controller.response;

import nju.software.entity.Project;

import java.util.List;

/**
 * Time       : 2019/1/12 11:27 PM
 * Author     : tangdaye
 * Description: /project response
 */
public class GetProjectByUserResponse {
    private String status;
    private List<Project> projectList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
