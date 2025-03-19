package com.example.kamjaexproject.controller;

import com.example.kamjaexproject.dto.UserRequestDto;
import com.example.kamjaexproject.dto.UserResponseDto;
import com.example.kamjaexproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto responseDto = userService.registerUser(userRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}
