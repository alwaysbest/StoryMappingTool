package nju.software.service;

import nju.software.entity.Log;

import java.util.List;

public interface LogService {
    List<Log> findLogsByProject(int projectId);
}
