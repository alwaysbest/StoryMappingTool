package nju.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UpdateController {
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }
}
