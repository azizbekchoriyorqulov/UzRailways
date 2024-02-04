package com.example.uzrailways.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Dalolatnoma")
@Getter
@Setter
public class Deed extends BaseEntity {
    public String name;
}
