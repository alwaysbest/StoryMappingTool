package nju.software.service.impl;

import nju.software.entity.Log;
import nju.software.repo.LogRepo;
import nju.software.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogRepo logRepo;


    @Override
    public List<Log> findLogsByProject(int projectId) {
        if(projectId<=0){
            return new ArrayList<>();
        }
        return logRepo.findLogsByProjectIdOrderByTime(projectId);
    }
}
