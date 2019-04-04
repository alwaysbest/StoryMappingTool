package nju.software.controller.response;

import lombok.Data;
import nju.software.entity.Log;

import java.util.List;

@Data
public class GetLogByProjectResponse {
    private String status;
    private List<Log> list;
}
