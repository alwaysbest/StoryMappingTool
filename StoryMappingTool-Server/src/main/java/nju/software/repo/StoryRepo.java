package nju.software.repo;

import nju.software.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Time       : 2019/1/9 12:38 AM
 * Author     : tangdaye
 * Description: 数据层代码
 */
@Repository
public interface StoryRepo extends JpaRepository<Story, Integer> {
    List<Story> findStoriesByProjectId(int projectId);
}
