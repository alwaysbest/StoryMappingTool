package nju.software.repo;

import nju.software.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Time       : 2019/1/13 9:13 PM
 * Author     : tangdaye
 * Description: 交付周期数据层
 */
@Repository
public interface ReleaseRepo extends JpaRepository<Release, Integer> {
    List<Release> findReleasesByProjectId(int projectId);
}
