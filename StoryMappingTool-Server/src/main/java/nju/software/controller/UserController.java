package nju.software.controller;

import nju.software.controller.request.GenerateEmailCodeRequest;
import nju.software.controller.request.LoginRequest;
import nju.software.controller.request.RegisterRequest;
import nju.software.controller.response.GenerateEmailCodeResponse;
import nju.software.controller.response.LoginResponse;
import nju.software.controller.response.RegisterResponse;
import nju.software.entity.User;
import nju.software.service.UserManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * Time       : 2019/1/10 11:14 PM
 * Author     : tangdaye
 * Description: 用户相关请求
 */
@CrossOrigin
@Controller
@ResponseBody
@RequestMapping(value = "/ui")
public class UserController {
    @Resource
    private UserManageService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        String email = request.getEmail();
        String password = request.getPassword();
        if (!service.existUser(email)) {
            response.setStatus("USER NOT EXIST");
        } else {
            User user = service.validateUser(email, password);
            if (user == null) {
                response.setStatus("WRONG PASSWORD");
            } else {
                response.setId(user.getId());
                response.setUsername(user.getUsername());
                response.setStatus("SUCCESS");
            }
        }
        return response;
    }

    @RequestMapping(value = "/emailcode", method = RequestMethod.POST)
    public GenerateEmailCodeResponse generateEmailCode(@RequestBody GenerateEmailCodeRequest request) {
        GenerateEmailCodeResponse response = new GenerateEmailCodeResponse();
        if (service.generateVerificationCode(request.getEmail())) {
            response.setStatus("SUCCESS");
        } else {
            response.setStatus("ALREADY EXIST");
        }
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        RegisterResponse response = new RegisterResponse();
        if (service.register(request.getUsername(), request.getEmail(), request.getPassword(), request.getCode())) {
            response.setStatus("SUCCESS");
        } else {
            response.setStatus("WRONG VERIFICATION CODE");
        }
        return response;
    }
}
