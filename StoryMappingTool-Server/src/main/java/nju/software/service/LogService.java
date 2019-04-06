package nju.software.service;

import nju.software.entity.Item;
import nju.software.entity.Log;
import nju.software.entity.OperationType;

import java.util.List;

public interface LogService {
    List<Log> findLogsByProject(int projectId);

    void insertLog(int projectId, int operator, Item item, int itemId, String title, OperationType operationType);
}
