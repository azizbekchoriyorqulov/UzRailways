package com.example.uzrailways.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequest {
    private String username;
    private String password;
}
