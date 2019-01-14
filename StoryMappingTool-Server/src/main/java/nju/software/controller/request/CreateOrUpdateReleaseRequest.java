package nju.software.controller.request;

/**
 * Time       : 2019/1/14 3:42 PM
 * Author     : tangdaye
 * Description: /ui/project/{id}/release request
 */
public class CreateOrUpdateReleaseRequest {
    private int releaseId;
    private int creatorId;
    private int sequenceId;
    private String title;
    private String description;
    private String start;
    private String end;
    private int status;

    public int getReleaseId() {
        return releaseId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getStatus() {
        return status;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
