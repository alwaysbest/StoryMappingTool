package nju.software.repo;

import nju.software.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Time       : 2019/1/13 4:47 PM
 * Author     : tangdaye
 * Description: 二级卡片数据层
 */
@Repository
public interface ActivityRepo extends JpaRepository<Activity, Integer> {
    List<Activity> findActivitiesByProjectId(int projectId);
}
