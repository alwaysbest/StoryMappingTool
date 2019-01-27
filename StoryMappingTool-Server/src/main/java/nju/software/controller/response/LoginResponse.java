package nju.software.controller.response;

import lombok.*;

/**
 * Time       : 2019/1/9 8:04 PM
 * Author     : tangdaye
 * Description: /ui/login response
 */
@Data
public class LoginResponse {
    private String status;
    private int id;
    private String username;

    public LoginResponse() {
    }
}
