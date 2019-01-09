package nju.software.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import nju.software.entity.User;
import org.springframework.stereotype.Service;

/**
 * Time       : 2019/1/9 7:58 PM
 * Author     : tangdaye
 * Description: 用户管理服务类
 */
public interface UserManagerService {
    Boolean existUser(String email);

    User validateUser(String email, String password);

    Boolean generateVerificationCode(String email);

    Boolean register(String username, String email, String password, String code);

}
