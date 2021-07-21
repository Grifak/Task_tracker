package com.gr1fak.task_tracker.controller;

import com.gr1fak.task_tracker.model.dto.request.UserRequestDto;
import com.gr1fak.task_tracker.model.dto.response.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "Пользователи")
@RestController
public class UserController {

    @Operation(summary = "Получить список пользователей")
    @GetMapping(value = "/users")
    public ResponseEntity<List<UserResponseDto>> getUsers(){
        UserResponseDto user = new UserResponseDto("user1", "1234");
        UserResponseDto user2 = new UserResponseDto("user2", "12345");

        List<UserResponseDto> res = List.of(user, user2);

        return ResponseEntity.ok().body(res);
    }

    @Operation(summary = "Добвить пользователя")
    @PostMapping(value = "/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto){
        //TODO добавление в БД

        return ResponseEntity.ok().body(new UserResponseDto(requestDto.getLogin(), requestDto.getPassword()));
    }

    @Operation(summary = "Обновление пользователя")
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id,
                                                      @RequestBody UserRequestDto requestDto){
        //TODO обновление сущности

        return ResponseEntity.ok().body(new UserResponseDto(requestDto.getLogin(), requestDto.getPassword()));
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
