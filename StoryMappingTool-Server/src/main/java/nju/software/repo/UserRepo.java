package nju.software.repo;

import nju.software.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Time       : 2019/1/8 8:03 PM
 * Author     : tangdaye
 * Description: 数据层代码
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    /**
        Description: 根据方法名解析的查询，通过email查询是否存在用户
        Input:       email
        Output:      如果存在，返回用户，否则返回Null
    */
    User findUserByEmail(String email);

    User findUserByEmailAndPasswd(String email, String passwd);
}
