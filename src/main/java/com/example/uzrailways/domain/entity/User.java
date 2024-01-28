package com.example.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "users")
@Getter
@Setter

public class User extends BaseEntity{
    public String username;
    public String password;
    public UUID kadrId;
    public String lavozim;
    @ManyToOne
    public Roll rol;
}
