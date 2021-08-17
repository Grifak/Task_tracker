package com.gr1fak.taskTracker.controller;

import com.gr1fak.taskTracker.dto.request.UserRequestDto;
import com.gr1fak.taskTracker.dto.response.UserResponseDto;
import com.gr1fak.taskTracker.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/api/user")
@Tag(name = "Пользователи")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Получить пользователя")
    @PreAuthorize("hasAuthority('admin:read')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable UUID id){
        UserResponseDto responseDto = userService.getById(id);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Добвить пользователя")
    @PreAuthorize("hasAuthority('admin:write')")
    @PostMapping(value = "/user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto){
        UserResponseDto responseDto = userService.addUser(requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Обновление пользователя")
    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id,
                                                      @RequestBody UserRequestDto requestDto){
        UserResponseDto responseDto = userService.updateUser(id, requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping(value = "/user/{id}")
    @PreAuthorize("hasAuthority('admin:write')")
    public ResponseEntity deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
