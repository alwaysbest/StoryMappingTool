package nju.software.repo;

import nju.software.entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Time       : 2019/1/13 4:47 PM
 * Author     : tangdaye
 * Description: 一级卡片数据层
 */
@Repository
public interface EpicRepo extends JpaRepository<Epic, Integer> {
    List<Epic> findEpicsByProjectId(int projectId);
}
