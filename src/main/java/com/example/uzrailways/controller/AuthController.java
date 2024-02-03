package com.example.uzrailways.controller;

import com.example.uzrailways.request.LoginRequest;
import com.example.uzrailways.request.UserRequest;
import com.example.uzrailways.response.ApiResponse;
import com.example.uzrailways.response.JwtResponse;
import com.example.uzrailways.service.AuthService.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/add-user")
    public ResponseEntity<ApiResponse> create(
            @RequestBody UserRequest userRequest
    ) {
        ApiResponse apiResponse = authService.create(userRequest);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(
            @RequestBody LoginRequest request
    ) {
        JwtResponse login = authService.login(request);
        return ResponseEntity.status(login.isSuccess() ? 200 : 403).body(login);
    }
}
