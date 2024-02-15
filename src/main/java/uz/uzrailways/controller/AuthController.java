package uz.uzrailways.controller;

import uz.uzrailways.domain.request.auth.LoginRequest;
import uz.uzrailways.domain.request.auth.UserRequest;
import uz.uzrailways.domain.response.ApiResponse;
import uz.uzrailways.domain.response.JwtResponse;
import uz.uzrailways.service.auth.jwt.AuthService;
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
