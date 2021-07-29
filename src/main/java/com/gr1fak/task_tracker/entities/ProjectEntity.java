package com.gr1fak.task_tracker.entities;

import com.gr1fak.task_tracker.dto.enums.ProjectStatus;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID projectId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status", nullable = false)
    private ProjectStatus status;

    @Column(name = "customer", nullable = false)
    private String customer;

    @OneToMany
    @JoinColumn(name = "task_id")
    private List<TaskEntity> tasks;

    public ProjectEntity(String name, String description, ProjectStatus status, String customer) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.customer = customer;
    }

    public ProjectEntity() {
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
