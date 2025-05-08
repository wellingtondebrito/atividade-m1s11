package com.futurodev.joinville.m1s11_atividade.services;

import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationResponseDto;

public interface AuthenticationService {

    AuthenticationResponseDto authenticate(AuthenticationRequestDto request);
    Object getInfo(String token);
}
