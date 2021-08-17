package com.gr1fak.taskTracker.dto.request;

import com.gr1fak.taskTracker.enums.UserRole;
import com.gr1fak.taskTracker.enums.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователь")
public class UserRequestDto {

    @Schema(description = "Логин пользователя")
    private String login;

    @Schema(description = "Пароль пользователя")
    private String password;

    @Schema(description = "Емайл пользователя")
    private String email;

    @Schema(description = "Статус пользователя")
    private UserStatus status;

    @Schema(description = "роль пользователя")
    private UserRole role;

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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
}
