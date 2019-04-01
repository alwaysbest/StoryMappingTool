package nju.software.repo;

import nju.software.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepo extends JpaRepository<Log, Integer> {
    List<Log> findLogsByProjectIdOrderByTime(int projectId);
}
