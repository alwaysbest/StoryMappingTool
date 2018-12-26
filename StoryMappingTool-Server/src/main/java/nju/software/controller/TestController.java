package nju.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Time       : 2018/12/25 11:33 PM
 * Author     : tangdaye
 * Description: 测试Controller
 */
@Controller
@ResponseBody
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }
}
