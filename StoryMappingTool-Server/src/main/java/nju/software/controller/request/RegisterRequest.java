package nju.software.controller.request;

import lombok.*;

/**
 * Time       : 2019/1/9 9:11 PM
 * Author     : tangdaye
 * Description: /ui/register request
 */
@Data
public class RegisterRequest {
    private String email;
    private String username;
    private String password;
    private String code;
}
