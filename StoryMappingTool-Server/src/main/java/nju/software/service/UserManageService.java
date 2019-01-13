package nju.software.service;
import nju.software.entity.User;

/**
 * Time       : 2019/1/9 7:58 PM
 * Author     : tangdaye
 * Description: 用户管理服务类
 */
public interface UserManageService {
    Boolean existUser(String email);

    User validateUser(String email, String password);

    Boolean generateVerificationCode(String email);

    Boolean register(String username, String email, String password, String code);

}
