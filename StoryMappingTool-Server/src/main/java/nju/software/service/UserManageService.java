package nju.software.service;

import nju.software.entity.User;

/**
 * Time       : 2019/1/9 7:58 PM
 * Author     : tangdaye
 * Description: 用户管理服务类
 */
public interface UserManageService {
    boolean existUser(String email);

    boolean existUser(int id);

    User validateUser(String email, String password);

    boolean generateVerificationCode(String email);

    boolean register(String username, String email, String password, String code);

}
