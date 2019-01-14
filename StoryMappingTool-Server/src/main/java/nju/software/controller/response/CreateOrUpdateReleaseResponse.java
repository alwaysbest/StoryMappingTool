package nju.software.controller.response;

import nju.software.entity.Release;

/**
 * Time       : 2019/1/14 3:42 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/release response
 */
public class CreateOrUpdateReleaseResponse {
    private String status;

    private Release release;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }
}
