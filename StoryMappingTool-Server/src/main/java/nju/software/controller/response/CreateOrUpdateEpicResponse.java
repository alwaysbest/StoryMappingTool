package nju.software.controller.response;

import nju.software.entity.Epic;

/**
 * Time       : 2019/1/13 10:55 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/epic response
 */
public class CreateOrUpdateEpicResponse {
    private String status;

    private Epic epic;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }
}
