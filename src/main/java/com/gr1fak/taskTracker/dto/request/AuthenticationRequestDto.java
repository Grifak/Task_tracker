package com.gr1fak.taskTracker.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Авторизация")
public class AuthenticationRequestDto {

    @Schema(description = "Логин пользователя")
    private String login;

    @Schema(description = "Пароль пользователя")
    private String password;

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
}
