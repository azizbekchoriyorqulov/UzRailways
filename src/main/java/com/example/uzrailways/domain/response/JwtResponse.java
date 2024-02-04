package com.example.uzrailways.domain.response;

import com.example.uzrailways.domain.enums.AuthRole;


import lombok.*;


import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class JwtResponse {
    private String token;
    private boolean success;
    private String username;
    private String firstName;
    private String lastName;
    private Set<AuthRole> roles;
}
