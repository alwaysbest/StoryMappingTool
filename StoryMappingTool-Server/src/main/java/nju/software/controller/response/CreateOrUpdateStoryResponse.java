package nju.software.controller.response;

import nju.software.entity.Story;

/**
 * Time       : 2019/1/14 3:42 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/story response
 */
public class CreateOrUpdateStoryResponse {
    private String status;

    private Story story;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}
