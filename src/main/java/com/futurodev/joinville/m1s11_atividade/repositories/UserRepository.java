package com.futurodev.joinville.m1s11_atividade.repositories;

import com.futurodev.joinville.m1s11_atividade.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
