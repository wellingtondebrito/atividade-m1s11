package com.futurodev.joinville.m1s11_atividade.controllers;

import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationResponseDto;
import com.futurodev.joinville.m1s11_atividade.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public AuthenticationResponseDto authenticate(@RequestBody AuthenticationRequestDto request) {
        return authenticationService.authenticate(request);
    }
}
