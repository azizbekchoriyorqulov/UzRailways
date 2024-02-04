package com.example.uzrailways.domain.entity;

import com.example.uzrailways.domain.enums.AuthRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
@Table(name = "user_roles")
public class Role extends BaseEntity implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    private AuthRole roleName;

    @Override
    public String getAuthority() {
        return roleName.name();
    }
}
