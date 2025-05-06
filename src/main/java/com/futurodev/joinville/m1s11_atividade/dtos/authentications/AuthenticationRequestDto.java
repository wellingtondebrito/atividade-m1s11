package com.futurodev.joinville.m1s11_atividade.dtos.authentications;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
