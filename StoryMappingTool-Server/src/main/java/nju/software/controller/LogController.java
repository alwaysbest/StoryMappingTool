package nju.software.controller;

import nju.software.controller.response.GetLogByProjectResponse;
import nju.software.entity.Log;
import nju.software.service.LogService;
import nju.software.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@ResponseBody
@RequestMapping(value = "/ui/log")
public class LogController {
    @Resource
    private LogService logService;

    @RequestMapping(value = "/project/{id}", method = RequestMethod.POST)
    public GetLogByProjectResponse getLogByProjectResponse(@PathVariable String id){
        GetLogByProjectResponse response = new GetLogByProjectResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int projectId = Integer.parseInt(id);
       List<Log> list =  logService.findLogsByProject(projectId);
       response.setList(list);
       response.setStatus("SUCCESS");
       return response;
    }
}
