package com.example.uzrailways.entity;

import com.example.uzrailways.entity.AuthRole;
import com.example.uzrailways.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.domain.Auditable;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    private AuthRole roleName;

    @Override
    public String getAuthority() {
        return roleName.name();
    }
}
