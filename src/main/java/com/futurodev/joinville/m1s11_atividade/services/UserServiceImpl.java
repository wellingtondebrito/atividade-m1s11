package com.futurodev.joinville.m1s11_atividade.services;

import com.futurodev.joinville.m1s11_atividade.dtos.users.UserRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.users.UserResponseDto;
import com.futurodev.joinville.m1s11_atividade.entities.User;
import com.futurodev.joinville.m1s11_atividade.enums.UserRole;
import com.futurodev.joinville.m1s11_atividade.mappers.UserMapper;
import com.futurodev.joinville.m1s11_atividade.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    private static final String DEFAULT_USER = "defaultUser";
    private static final String DEFAULT_PASSWORD = "defaultPassword";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }
        if(username.equals(DEFAULT_USER)){
           return User.builder()
                    .id(0L)
                    .name("Default User")
                    .username(DEFAULT_USER)
                    .password(encoder.encode(DEFAULT_PASSWORD))
                    .role(UserRole.ADMIN)
                    .build();
        }

        throw new UsernameNotFoundException("User not found");

    }

    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.toDtoList(users);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userDto) {
        User user = new User();
        UserMapper.toEntity(user, userDto);

        user.setPassword(encoder.encode(userDto.getPassword()));

        user = userRepository.save(user);
        return UserMapper.toDto(user);
    }




    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        UserMapper.toEntity(user, userDto);
        userRepository.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }


}
