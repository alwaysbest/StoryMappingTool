package nju.software.controller.response;

import nju.software.entity.Activity;

/**
 * Time       : 2019/1/13 10:55 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/activity response
 */
public class CreateOrUpdateActivityResponse {
    private String status;

    private Activity activity;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
