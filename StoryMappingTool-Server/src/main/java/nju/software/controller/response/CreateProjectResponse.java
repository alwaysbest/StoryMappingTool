package nju.software.controller.response;

import nju.software.entity.Epic;
import nju.software.entity.Project;

/**
 * Time       : 2019/1/12 11:37 PM
 * Author     : tangdaye
 * Description: /project response
 */
public class CreateProjectResponse {
    private String status;

    private Project project;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
