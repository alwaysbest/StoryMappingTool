package nju.software.service.impl;

import nju.software.entity.User;
import nju.software.repo.UserRepo;
import nju.software.service.UserManagerService;
import nju.software.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Time       : 2019/1/9 8:00 PM
 * Author     : tangdaye
 * Description: 用户管理服务实现
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {
    @Resource
    private UserRepo repo;

    @Override
    public Boolean existUser(String email) {
        User user = repo.findUserByEmail(email);
        System.out.println(user);
        return user != null && user.getVerificationCode() == null;
    }

    @Override
    public User validateUser(String email, String password) {
        String md5 = StringUtil.getMD5(password);
        return repo.findUserByEmailAndPasswd(email, md5);
    }

    @Override
    public Boolean generateVerificationCode(String email) {
        User userDto = repo.findUserByEmail(email);
        User user = null;
        if (userDto != null) {
            if (userDto.getVerificationCode() == null) {
                return false;
            } else {
                user = userDto;
            }
        }
        if (user == null) {
            user = new User();
        }
        user.setEmail(email);
        String code = StringUtil.generateRandomString(4);
        // todo 发送邮件
        user.setVerificationCode(code);
        User result = repo.saveAndFlush(user);
        return result != null;
    }

    @Override
    public Boolean register(String username, String email, String password, String code) {
        User userDto = repo.findUserByEmail(email);
        if (userDto == null || !userDto.getVerificationCode().equals(code)) {//如果不存在或者验证码不一致
            return false;
        }
        userDto.setUsername(username);
        userDto.setPasswd(StringUtil.getMD5(password));
        userDto.setCreateAt(new Date());
        userDto.setVerificationCode(null); //设置为null表示已经验证

        User result = repo.saveAndFlush(userDto);
        return result != null;
    }
}
