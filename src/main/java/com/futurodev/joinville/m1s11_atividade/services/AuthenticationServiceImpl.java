package com.futurodev.joinville.m1s11_atividade.services;

import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.authentications.AuthenticationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder encoder;

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        UserDetails user = userService.loadUserByUsername(request.getUsername());
        if(!encoder.matches(request.getPassword(), user.getPassword())){
            throw new UsernameNotFoundException(user.getUsername());
        }
        String token = request.getUsername() + ":" + request.getPassword();
        token = Base64.getEncoder().encodeToString(token.getBytes());

        return AuthenticationResponseDto.builder()
                .type("Basic")
                .token(token)
                .build();

    }
}
