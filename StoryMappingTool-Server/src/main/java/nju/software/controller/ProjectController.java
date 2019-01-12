package nju.software.controller;

import nju.software.controller.request.CreateProjectRequest;
import nju.software.controller.request.GetProjectByUserRequest;
import nju.software.controller.response.CreateProjectResponse;
import nju.software.controller.response.GetProjectByUserResponse;
import nju.software.service.ProjectManageService;
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
    private ProjectManageService service;

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public GetProjectByUserResponse getProjectByUser(@RequestBody GetProjectByUserRequest request) {
        return null;
    }

    @RequestMapping(value = "/project/create", method = RequestMethod.POST)
    public CreateProjectResponse createProject(CreateProjectRequest request) {
        return null;
    }

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public void getProject(@PathVariable String id) {
        System.out.println(id);
    }


}
