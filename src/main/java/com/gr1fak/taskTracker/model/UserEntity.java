package com.gr1fak.taskTracker.model;

import com.gr1fak.taskTracker.enums.UserRole;
import com.gr1fak.taskTracker.enums.UserStatus;

import javax.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private UserStatus userStatus;

    @ManyToMany
    @JoinTable(name = "users_tasks",
        joinColumns = @JoinColumn (name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Set<TaskEntity> tasks;

    public UserEntity() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Set<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
