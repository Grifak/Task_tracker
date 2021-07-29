package com.gr1fak.task_tracker.entities;

import com.gr1fak.task_tracker.dto.enums.TaskStatus;
import com.gr1fak.task_tracker.entities.ProjectEntity;
import com.gr1fak.task_tracker.entities.ReleaseEntity;
import com.gr1fak.task_tracker.entities.UserEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import java.util.Set;
import java.util.UUID;

@Table(name = "task")
@Entity
public class TaskEntity {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private TaskStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "release_id")
    private ReleaseEntity release;

    @ManyToMany
    private Set<UserEntity> executors;

    public TaskEntity(String name, TaskStatus status) {
        this.name = name;
        this.status = status;
    }

    public TaskEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
