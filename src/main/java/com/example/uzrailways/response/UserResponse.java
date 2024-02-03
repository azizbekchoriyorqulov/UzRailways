package com.example.uzrailways.response;

import com.example.uzrailways.entity.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Set<Role> roles;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;
}
