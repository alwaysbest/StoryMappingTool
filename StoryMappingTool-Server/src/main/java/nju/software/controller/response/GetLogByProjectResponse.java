package nju.software.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class GetLogByProjectResponse {
    private String status;
    private List<String> list;
}
