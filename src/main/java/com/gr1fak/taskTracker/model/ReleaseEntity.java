package com.gr1fak.taskTracker.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Set;

@Table(name = "release")
@Entity
public class ReleaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name  = "release_id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "begin", nullable = false)
    private LocalDateTime begin;

    @Column(name = "ending", nullable = false)
    private LocalDateTime end;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    Set<TaskEntity> tasks;


    public ReleaseEntity() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Set<TaskEntity> getTasks() {
        return tasks;
    }

    public void addTask(TaskEntity task) {
        this.tasks.add(task);
    }
}
