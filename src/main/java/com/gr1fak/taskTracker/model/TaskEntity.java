package com.gr1fak.taskTracker.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gr1fak.taskTracker.enums.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;

import java.util.UUID;
import java.util.Set;

@JsonPropertyOrder({"name", "status"})
@Table(name = "task")
@Entity
public class TaskEntity {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TaskStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "release_id")
    private ReleaseEntity release;

    @ManyToMany
    @JoinTable(name = "users_tasks",
            joinColumns = @JoinColumn (name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserEntity> executors;

    public TaskEntity() {
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

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public ReleaseEntity getRelease() {
        return release;
    }

    public void setRelease(ReleaseEntity release) {
        this.release = release;
    }

    public Set<UserEntity> getExecutors() {
        return executors;
    }

    public void addExecutor(UserEntity user) {
        this.executors.add(user);
    }
}
