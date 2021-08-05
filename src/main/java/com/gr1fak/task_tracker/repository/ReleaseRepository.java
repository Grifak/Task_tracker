package com.gr1fak.task_tracker.repository;

import com.gr1fak.task_tracker.model.ReleaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseEntity, UUID> {
}
