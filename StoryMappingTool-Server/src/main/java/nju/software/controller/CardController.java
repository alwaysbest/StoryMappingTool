package nju.software.controller;

import nju.software.controller.request.CreateOrUpdateActivityRequest;
import nju.software.controller.request.CreateOrUpdateEpicRequest;
import nju.software.controller.request.CreateOrUpdateReleaseRequest;
import nju.software.controller.request.CreateOrUpdateStoryRequest;
import nju.software.controller.response.CreateOrUpdateActivityResponse;
import nju.software.controller.response.CreateOrUpdateEpicResponse;
import nju.software.controller.response.CreateOrUpdateReleaseResponse;
import nju.software.controller.response.CreateOrUpdateStoryResponse;
import nju.software.entity.*;
import nju.software.service.CardManageService;
import nju.software.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@Controller
@ResponseBody
@RequestMapping(value = "/ui/project/{id}")
public class CardController {
    @Resource
    private CardManageService cardManageService;

    @RequestMapping(value = "/insert/epic", method = RequestMethod.POST)
    public CreateOrUpdateEpicResponse insertEpic(@PathVariable String id,
                                                 @RequestBody CreateOrUpdateEpicRequest request){
        CreateOrUpdateEpicResponse response = new CreateOrUpdateEpicResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int idInt = Integer.parseInt(id);
        Epic epic = cardManageService.insertEpic(idInt, request.getSequenceId(), request.getTitle(), request.getDescription());
        if (epic != null) {
            response.setStatus("SUCCESS");
            response.setEpic(epic);
            return response;
        }
        response.setStatus("FAILURE");
        return response;
    }

    @RequestMapping(value = "/insert/activity", method = RequestMethod.POST)
    public CreateOrUpdateActivityResponse insertActivity(@PathVariable String id,
                                                          @RequestBody CreateOrUpdateActivityRequest request){
        CreateOrUpdateActivityResponse response = new CreateOrUpdateActivityResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int idInt = Integer.parseInt(id);
        Activity activity = cardManageService.insertActivity(idInt, request.getEpicId(), request.getSequenceId(),
                request.getTitle(), request.getDescription());
        if (activity != null) {
            response.setStatus("SUCCESS");
            response.setActivity(activity);
            return response;
        }
        response.setStatus("FAILURE");
        return response;
    }

    @RequestMapping(value = "/insert/story", method = RequestMethod.POST)
    public CreateOrUpdateStoryResponse insertStory(@PathVariable String id,
                                                       @RequestBody CreateOrUpdateStoryRequest request){
        CreateOrUpdateStoryResponse response = new CreateOrUpdateStoryResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int idInt = Integer.parseInt(id);
        Status[] statuses = {Status.UNDO, Status.DOING, Status.DONE};
        Story story = cardManageService.insertStory(
                idInt,
                request.getEpicId(),
                request.getActivityId(),
                request.getReleaseId(),
                request.getSequenceId(),
                request.getTitle(),
                request.getDescription(),
                request.getPoints(),
                StringUtil.string2Date(request.getStart()),
                StringUtil.string2Date(request.getEnd()),
                statuses[request.getStatus()]
        );
        if (story != null) {
            response.setStatus("SUCCESS");
            response.setStory(story);
            return response;
        }
        response.setStatus("FAILURE");
        return response;
    }

    @RequestMapping(value = "/insert/release", method = RequestMethod.POST)
    public CreateOrUpdateReleaseResponse insertRelease(@PathVariable String id,
                                                         @RequestBody CreateOrUpdateReleaseRequest request){
        CreateOrUpdateReleaseResponse response = new CreateOrUpdateReleaseResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int idInt = Integer.parseInt(id);
        Status[] statuses = {Status.UNDO, Status.DOING, Status.DONE};
        Release release = cardManageService.insertRelease(
                idInt,
                request.getSequenceId(),
                request.getTitle(),
                request.getDescription(),
                StringUtil.string2Date(request.getStart()),
                StringUtil.string2Date(request.getEnd()),
                statuses[request.getStatus()]);
        if (release != null) {
            response.setStatus("SUCCESS");
            response.setRelease(release);
            return response;
        }
        response.setStatus("FAILURE");
        return response;
    }

    @RequestMapping(value = "/epic/{epic_id}", method = RequestMethod.DELETE)
    public Boolean deleteEpic(@PathVariable String id,
                             @PathVariable String epic_id){
        if(!(StringUtil.isNumeric(id) && StringUtil.isNumeric(epic_id))){
            return false;
        }
        int epicId = Integer.valueOf(epic_id);
        return cardManageService.deleteEpic(epicId);
    }

    @RequestMapping(value = "/activity/{activity_id}", method = RequestMethod.DELETE)
    public Boolean deleteActivity(@PathVariable String id,
                              @PathVariable String activity_id){
        if(!(StringUtil.isNumeric(id) && StringUtil.isNumeric(activity_id))){
            return false;
        }
        int activityId = Integer.valueOf(activity_id);
        return cardManageService.deleteActivity(activityId);
    }

    @RequestMapping(value = "/story/{story_id}", method = RequestMethod.DELETE)
    public Boolean deleteStory(@PathVariable String id,
                                  @PathVariable String story_id){
        if(!(StringUtil.isNumeric(id) && StringUtil.isNumeric(story_id))){
            return false;
        }
        int storyId = Integer.valueOf(story_id);
        return cardManageService.deleteStory(storyId);
    }

    @RequestMapping(value = "/release/{release_id}", method = RequestMethod.DELETE)
    public Boolean deleteRelease(@PathVariable String id,
                               @PathVariable String release_id){
        if(!(StringUtil.isNumeric(id) && StringUtil.isNumeric(release_id))){
            return false;
        }
        int releaseId = Integer.valueOf(release_id);
        return cardManageService.deleteRelease(releaseId);
    }
}
