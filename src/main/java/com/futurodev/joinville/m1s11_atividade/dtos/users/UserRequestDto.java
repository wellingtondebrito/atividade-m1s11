package com.futurodev.joinville.m1s11_atividade.dtos.users;

import com.futurodev.joinville.m1s11_atividade.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String name;
    private String username;
    private String password;
    private UserRole role;
}
