package nju.software.controller;

import nju.software.App;
import nju.software.controller.response.GetProjectResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Time       : 2019/1/15 4:01 PM
 * Author     : tangdaye
 * Description: 项目管理控制器测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ProjectControllerTest {
    @Resource
    ProjectController controller;

    //就测试一个方法……
    @Test
    public void test1() {
        GetProjectResponse response = controller.getProject("1");
        System.out.println(response);
    }
}
