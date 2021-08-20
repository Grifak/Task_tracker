package com.gr1fak.taskTracker.repository;

import com.gr1fak.taskTracker.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID>, JpaSpecificationExecutor<TaskEntity> {

    @Query(nativeQuery = true,
        value = "SELECT * FROM task t WHERE t.project_id=:id")
    List<TaskEntity> findAllByProjectId(@Param("id") UUID id);

    @Query(nativeQuery = true,
            value = "SELECT * FROM task t WHERE t.release_id=:id AND t.status!='DONE'")
    List<TaskEntity> getIncompleteTaskInRelease(@Param("id") UUID releaseId);
}
