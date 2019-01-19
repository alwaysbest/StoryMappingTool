package nju.software.controller.request;

import lombok.*;

/**
 * Time       : 2019/1/9 7:55 PM
 * Author     : tangdaye
 * Description: /ui/login req
 */
@Data
public class LoginRequest {
    private String email;
    private String password;
}
