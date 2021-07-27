package com.gr1fak.task_tracker.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import java.time.LocalDateTime;
import java.util.UUID;;

@Table(name = "release")
@Entity
public class ReleaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name  = "release_id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "begin")
    private LocalDateTime begin;

    @Column(name = "end")
    private LocalDateTime end;

    public ReleaseEntity(String name, LocalDateTime begin, LocalDateTime end) {
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public ReleaseEntity() {
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
}
