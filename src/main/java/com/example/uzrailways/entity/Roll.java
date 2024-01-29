package com.example.uzrailways.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Roll")
@Getter
@Setter
public class Roll  extends BaseEntity{
    public String name;
}
