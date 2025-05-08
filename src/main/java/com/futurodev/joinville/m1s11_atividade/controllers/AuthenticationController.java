package com.futurodev.joinville.m1s11_atividade.controllers;

import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationResponseDto;
import com.futurodev.joinville.m1s11_atividade.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping
    public Object login(@RequestHeader("Authorization") String token) {
        return authenticationService.getInfo(token);
    }

    @PostMapping
    public AuthenticationResponseDto authenticate(@RequestBody AuthenticationRequestDto request) {
        return authenticationService.authenticate(request);
    }
}
