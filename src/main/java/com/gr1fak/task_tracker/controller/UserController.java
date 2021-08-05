package com.gr1fak.task_tracker.controller;

import com.gr1fak.task_tracker.dto.request.UserRequestDto;
import com.gr1fak.task_tracker.dto.response.UserResponseDto;
import com.gr1fak.task_tracker.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/user")
@Tag(name = "Пользователи")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Получить пользователя")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable UUID id){
        UserResponseDto responseDto = userService.getById(id);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Добвить пользователя")
    @PostMapping(value = "/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto){
        UserResponseDto responseDto = userService.addUser(requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Обновление пользователя")
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id,
                                                      @RequestBody UserRequestDto requestDto){
        //TODO обновление сущности

        return ResponseEntity.ok().body(new UserResponseDto());
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
