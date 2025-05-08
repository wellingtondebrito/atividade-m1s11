package com.futurodev.joinville.m1s11_atividade.services;

import com.futurodev.joinville.m1s11_atividade.config.JwtConfig;
import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationResponseDto;
import com.futurodev.joinville.m1s11_atividade.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtConfig jwtComponent;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                     request.getUsername(), request.getPassword()
                )
        );

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new BadCredentialsException("Invalid username or password");
        }

        User user = (User) authentication.getPrincipal();

        String token = jwtComponent.generateToken(user);
        return AuthenticationResponseDto.builder().type("Bearer").token(token).build();

    }

    @Override
    public Object getInfo(String token) {
        return jwtComponent.parseClaims(
                token.split(" ")[1]
        ).getBody();
    }
}
