package nju.software.service;


import nju.software.entity.*;

import java.util.Date;

public interface CardManageService {
    Epic insertEpic(int projectId, int sequenceId, String title, String description);

    Activity insertActivity(int projectId, int epicId, int sequenceId, String title, String description);

    Story insertStory(int projectId, int epicId, int activityId, int releaseId, int sequenceId,
                      String title, String description, int points, Date start, Date end, Status status);

    Release insertRelease(int projectId, int sequenceId, String title, String description,
                          Date start, Date end, Status status);

    Boolean deleteEpic(int epicId);

    Boolean deleteActivity(int activityId);

    Boolean deleteStory(int storyId);

    Boolean deleteRelease(int releaseId);
}
