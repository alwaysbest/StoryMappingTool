package nju.software.controller.request;

/**
 * Time       : 2019/1/13 10:55 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/epic request
 */
public class CreateOrUpdateEpicRequest {
    private int epicId;
    private int creatorId;
    private int sequenceId;
    private String title;
    private String description;

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
