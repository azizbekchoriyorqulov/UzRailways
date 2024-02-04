package com.example.uzrailways.repository;

import com.example.uzrailways.domain.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {
    Boolean existsByUsername(String username);

    Optional<AuthUser> findByUsername(String username);
}

