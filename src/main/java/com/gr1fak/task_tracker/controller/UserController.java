package com.gr1fak.task_tracker.controller;

import com.gr1fak.task_tracker.dto.request.UserRequestDto;
import com.gr1fak.task_tracker.dto.response.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@RequestMapping("/api/user")
@Tag(name = "Пользователи")
@RestController
public class UserController {

    @Operation(summary = "Получить список пользователей")
    @GetMapping(value = "/users")
    public ResponseEntity<List<UserResponseDto>> getUsers(){
        UserResponseDto user = new UserResponseDto("user1", "1234", "us@mail.ru");
        UserResponseDto user2 = new UserResponseDto("user2", "123456","us1@mail.ru");

        List<UserResponseDto> res = List.of(user, user2);

        return ResponseEntity.ok().body(res);
    }

    @Operation(summary = "Добвить пользователя")
    @PostMapping(value = "/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto){
        //TODO добавление в БД

        return ResponseEntity.ok().body(new UserResponseDto(requestDto.getLogin(), requestDto.getPassword(),
                requestDto.getEmail()));
    }

    @Operation(summary = "Обновление пользователя")
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id,
                                                      @RequestBody UserRequestDto requestDto){
        //TODO обновление сущности

        return ResponseEntity.ok().body(new UserResponseDto(requestDto.getLogin(), requestDto.getPassword(),
                requestDto.getEmail()));
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        //TODO удаление сущности

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
