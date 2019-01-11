package nju.software.controller;

import nju.software.controller.request.GenerateEmailCodeRequest;
import nju.software.controller.request.LoginRequest;
import nju.software.controller.request.RegisterRequest;
import nju.software.controller.response.GenerateEmailCodeResponse;
import nju.software.controller.response.LoginResponse;
import nju.software.controller.response.RegisterResponse;
import nju.software.entity.User;
import nju.software.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@ResponseBody
@RequestMapping(value = "/ui")
public class UserController {
    @Resource
    private UserManagerService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        String email = request.getEmail();
        String password = request.getPassword();
        if (!service.existUser(email)) {
            response.setStatus("USER_NOT_EXIST");
        } else {
            User user = service.validateUser(email, password);
            if (user == null) {
                response.setStatus("WRONG_PASSWORD");
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
