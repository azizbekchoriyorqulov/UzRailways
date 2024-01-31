package com.example.uzrailways.repository;

import com.example.uzrailways.entity.Kadr;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KadrRepository extends JpaRepository<Kadr, UUID> {
}
