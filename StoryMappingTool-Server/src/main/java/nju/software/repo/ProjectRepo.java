package nju.software.repo;

import nju.software.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Time       : 2019/1/13 4:47 PM
 * Author     : tangdaye
 * Description: 项目数据层
 */
@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
    @Query("select p from Project p,UserProject up where p.id=up.projectId and up.userId=?1")
    List<Project> findProjectsByUserId(int userId);
}
