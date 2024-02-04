package com.example.uzrailways.repository;

import com.example.uzrailways.domain.entity.Cadre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KadrRepository extends JpaRepository<Cadre, UUID> {
}
