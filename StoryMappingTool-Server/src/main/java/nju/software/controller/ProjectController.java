package nju.software.controller;

import nju.software.controller.request.*;
import nju.software.controller.response.*;
import nju.software.entity.*;
import nju.software.service.ProjectManageService;
import nju.software.service.UserManageService;
import nju.software.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Time       : 2019/1/12 11:14 PM
 * Author     : tangdaye
 * Description: 项目相关请求
 */
@CrossOrigin
@Controller
@ResponseBody
@RequestMapping(value = "/ui")
public class ProjectController {
    @Resource
    private ProjectManageService projectManageService;
    @Resource
    private UserManageService userManageService;

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public CreateOrUpdateProjectResponse createProject(@RequestBody CreateOrUpdateProjectRequest request) {
        CreateOrUpdateProjectResponse response = new CreateOrUpdateProjectResponse();
        if (request.getProjectId() == 0 || projectManageService.existProject(request.getProjectId())) {
            Project p = projectManageService.updateProject(request.getProjectId(), request.getTitle(), request.getDescription());
            if (p != null) {
                response.setStatus("SUCCESS");
                response.setProject(p);
            } else {
                response.setStatus("FAILURE");
            }
        } else {
            Project p = projectManageService.createProject(request.getCreatorId(), request.getTitle(), request.getDescription());
            if (p != null) {
                response.setStatus("SUCCESS");
                response.setProject(p);
            } else {
                response.setStatus("FAILURE");
            }
        }
        return response;
    }


    @RequestMapping(value = "/project/{id}/invite-members", method = RequestMethod.POST)
    public InviteMemberResponse inviteMember(@PathVariable String id, @RequestBody InviteMemberRequest request) {
        InviteMemberResponse response = new InviteMemberResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("NOT_EXIST");
            return response;
        }
        int idInt = Integer.parseInt(id);
        if (!projectManageService.existProject(idInt)) {
            response.setStatus("NOT_EXIST");
            return response;
        }
        if (!userManageService.existUser(request.getEmail())) {
            response.setStatus("NOT_EXIST");
            return response;
        }
        boolean flag = projectManageService.inviteMember(idInt, request.getEmail());
        if (flag) {
            response.setStatus("SUCCESS");
        } else {
            response.setStatus("ALREADY_EXIST");
        }
        return response;

    }

    @RequestMapping(value = "/list-project", method = RequestMethod.POST)
    public GetProjectByUserResponse getProjectByUser(@RequestBody GetProjectByUserRequest request) {
        GetProjectByUserResponse response = new GetProjectByUserResponse();
        if (!userManageService.existUser(request.getUserId())) {
            response.setStatus("FAILURE");
            return response;
        }
        response.setStatus("SUCCESS");
        response.setProjectList(projectManageService.getProjectsByUser(request.getUserId()));
        return response;
    }


    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public GetProjectResponse getProject(@PathVariable String id) {
        GetProjectResponse response = new GetProjectResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int idInt = Integer.parseInt(id);
        if (!projectManageService.existProject(idInt)) {
            response.setStatus("FAILURE");
            return response;
        }
        response.setStatus("SUCCESS");
        setProject(response, idInt);
        return response;
    }

    @RequestMapping(value = "/project/{id}/epic", method = RequestMethod.POST)
    public GetProjectResponse createOrUpdateEpic(@PathVariable String id,
                                                 @RequestBody CreateOrUpdateEpicRequest request) {
        GetProjectResponse response = new GetProjectResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int idInt = Integer.parseInt(id);
        if (request.getId() == 0) {
            Epic epic = projectManageService.createEpic(idInt, request.getSequenceId(), request.getTitle(), request.getDescription());
            if (epic != null) {
                response.setStatus("SUCCESS");
            } else {
                response.setStatus("FAILURE");
                return response;
            }
        } else {
            Epic epic = projectManageService.updateEpic(request.getId(), idInt, request.getSequenceId(), request.getTitle(), request.getDescription());
            if (epic != null) {
                response.setStatus("SUCCESS");
            } else {
                response.setStatus("FAILURE");
                return response;
            }
        }
        setProject(response, idInt);
        return response;
    }

    @RequestMapping(value = "/project/{id}/activity", method = RequestMethod.POST)
    public GetProjectResponse createOrUpdateActivity(@PathVariable String id,
                                                     @RequestBody CreateOrUpdateActivityRequest request) {
        GetProjectResponse response = new GetProjectResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int idInt = Integer.parseInt(id);
        if (request.getId() == 0) {
            Activity activity = projectManageService.createActivity(idInt, request.getEpicId(), request.getSequenceId(),
                    request.getTitle(), request.getDescription());
            if (activity != null) {
                response.setStatus("SUCCESS");
            } else {
                response.setStatus("FAILURE");
                return response;
            }
        } else {
            Activity activity = projectManageService.updateActivity(request.getId(), idInt, request.getEpicId(),
                    request.getSequenceId(), request.getTitle(), request.getDescription());
            if (activity != null) {
                response.setStatus("SUCCESS");
            } else {
                response.setStatus("FAILURE");
                return response;
            }
        }
        setProject(response, idInt);
        return response;
    }

    @RequestMapping(value = "/project/{id}/story", method = RequestMethod.POST)
    public GetProjectResponse createOrUpdateStory(@PathVariable String id,
                                                  @RequestBody CreateOrUpdateStoryRequest request) {
        GetProjectResponse response = new GetProjectResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int idInt = Integer.parseInt(id);
        Status[] statuses = {Status.UNDO, Status.DOING, Status.DONE};
        if (request.getId() == 0) {
            Story story = projectManageService.createStory(
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
            } else {
                response.setStatus("FAILURE");
                return response;
            }
        } else {
            Story story = projectManageService.updateStory(
                    request.getId(),
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
            } else {
                response.setStatus("FAILURE");
                return response;
            }
        }
        setProject(response, idInt);
        return response;
    }

    @RequestMapping(value = "/project/{id}/release", method = RequestMethod.POST)
    public GetProjectResponse createOrUpdateRelease(@PathVariable String id,
                                                    @RequestBody CreateOrUpdateReleaseRequest request) {
        GetProjectResponse response = new GetProjectResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int idInt = Integer.parseInt(id);
        Status[] statuses = {Status.UNDO, Status.DOING, Status.DONE};
        if (request.getId() == 0) {
            Release release = projectManageService.createRelease(
                    idInt,
                    request.getSequenceId(),
                    request.getTitle(),
                    request.getDescription(),
                    StringUtil.string2Date(request.getStart()),
                    StringUtil.string2Date(request.getEnd()),
                    statuses[request.getStatus()]
            );
            if (release != null) {
                response.setStatus("SUCCESS");
            } else {
                response.setStatus("FAILURE");
                return response;
            }
        } else {
            Release release = projectManageService.updateRelease(
                    request.getId(),
                    idInt,
                    request.getSequenceId(),
                    request.getTitle(),
                    request.getDescription(),
                    StringUtil.string2Date(request.getStart()),
                    StringUtil.string2Date(request.getEnd()),
                    statuses[request.getStatus()]
            );
            if (release != null) {
                response.setStatus("SUCCESS");
            } else {
                response.setStatus("FAILURE");
                return response;
            }
        }
        setProject(response, idInt);
        return response;
    }

    private void setProject(GetProjectResponse response, int idInt) {
        response.setId(idInt);
        response.setMemberList(projectManageService.getMembersByProject(idInt));
        response.setEpicList(projectManageService.getEpicsByProject(idInt),
                projectManageService.getActivitiesByProject(idInt),
                projectManageService.getStoriesByProject(idInt));
        response.setReleaseList(projectManageService.getReleasesByProject(idInt));
    }


}
