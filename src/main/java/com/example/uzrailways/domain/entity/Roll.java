package com.example.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Roll")
@Getter
@Setter
public class Roll  extends BaseEntity{
    public String name;
}
