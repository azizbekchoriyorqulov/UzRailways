package com.example.uzrailways.repository;

import com.example.uzrailways.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PhotoRepository extends JpaRepository<Photo , UUID>
{
    @Query("SELECT p.fileUrl FROM photo p WHERE p.id = :id")
    Optional<String> findFileUrlById(@Param("id") UUID id);
}