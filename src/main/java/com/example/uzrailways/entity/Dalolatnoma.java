package com.example.uzrailways.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Dalolatnoma")
@Getter
@Setter
public class Dalolatnoma extends BaseEntity {
    public String name;
}
