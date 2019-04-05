package nju.software.controller;

import nju.software.controller.response.GetLogByProjectResponse;
import nju.software.entity.Log;
import nju.software.service.LogService;
import nju.software.service.UserManageService;
import nju.software.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@ResponseBody
@RequestMapping(value = "/ui/log")
public class LogController {
    @Resource
    private LogService logService;

    @Resource
    private UserManageService userManageService;

    @RequestMapping(value = "/project/{id}", method = RequestMethod.POST)
    public GetLogByProjectResponse getLogByProjectResponse(@PathVariable String id){
        GetLogByProjectResponse response = new GetLogByProjectResponse();
        if (!StringUtil.isNumeric(id)) {
            response.setStatus("FAILURE");
            return response;
        }
        int projectId = Integer.parseInt(id);
       List<Log> list =  logService.findLogsByProject(projectId);
       response.setList(getLogString(list));
       response.setStatus("SUCCESS");
       return response;
    }

    private List<String> getLogString(List<Log> logList){
        List<String> result = new ArrayList<>();
        if(logList == null || logList.size() == 0){
            return result;
        }
        for (Log log : logList){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = simpleDateFormat.format(log.getTime());
            String user = userManageService.getUsername(log.getOperator());
            String operationType = "";
            switch (log.getOperationType()){
                case CREATE:
                    operationType = "新增";break;
                case MODIFY:
                    operationType = "修改";break;
                case DELETE:
                    operationType = "删除";break;
                 default:
                     operationType = "未知操作";break;
            }
            String line = timestamp + "  " + user + operationType + log.getItem() + "'" + log.getTitle() + "'";
            result.add(line);
        }
        return result;
    }
}
