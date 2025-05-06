package com.futurodev.joinville.m1s11_atividade.mappers;

import com.futurodev.joinville.m1s11_atividade.dtos.users.UserRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.users.UserResponseDto;
import com.futurodev.joinville.m1s11_atividade.entities.User;

import java.util.List;

public class UserMapper {
    private UserMapper() {}

    public static UserResponseDto toDto (User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    public static List<UserResponseDto> toDtoList (List<User> users){
        return users.stream()
                .map(UserMapper::toDto)
                .toList();
    }

    public static User toEntity (User user , UserRequestDto userDto){
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        return user;
    }
}