package com.gr1fak.task_tracker.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователь")
public class UserRequestDto {
    @Schema(description = "ID пользователя")
    private Long user_id;

    @Schema(description = "Логин пользователя")
    private String login;

    @Schema(description = "Пароль пользователя")
    private String password;

    @Schema(description = "Емайл пользователя")
    private String email;

    public UserRequestDto(Long user_id, String login, String password, String email) {
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
