package nju.software.repo;

import nju.software.entity.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Time       : 2019/1/13 9:05 PM
 * Author     : tangdaye
 * Description: 用户项目数据层
 */
@Repository
public interface UserProjectRepo extends JpaRepository<UserProject, Integer> {
    UserProject findUserProjectByUserIdAndProjectId(int userId, int projectId);
}
