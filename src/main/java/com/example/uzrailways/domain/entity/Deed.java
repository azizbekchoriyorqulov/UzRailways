package com.example.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Dalolatnoma
 */
@Entity(name = "deeds")
@Getter
@Setter
public class Deed extends BaseEntity {
    private String name;
}
