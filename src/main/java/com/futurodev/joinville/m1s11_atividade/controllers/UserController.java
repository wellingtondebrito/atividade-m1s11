package com.futurodev.joinville.m1s11_atividade.controllers;

import com.futurodev.joinville.m1s11_atividade.dtos.users.UserRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.users.UserResponseDto;
import com.futurodev.joinville.m1s11_atividade.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
