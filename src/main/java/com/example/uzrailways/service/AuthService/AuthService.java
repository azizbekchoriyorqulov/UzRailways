package com.example.uzrailways.service.AuthService;

import com.example.uzrailways.Exeption.RecordNotFoundException;
import com.example.uzrailways.entity.AuthUser;
import com.example.uzrailways.jwt.JwtService;
import com.example.uzrailways.repository.UserRepository;
import com.example.uzrailways.request.LoginRequest;
import com.example.uzrailways.request.UserRequest;
import com.example.uzrailways.response.ApiResponse;
import com.example.uzrailways.response.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    public ApiResponse create(UserRequest userRequest) {
        try {
            if (userRepository.existsByUsername(userRequest.getUsername())) {
                return new ApiResponse(false, "This is username already exist");
            }
            if (userRequest.getJshshir().length() != 14) {
                return new ApiResponse(false, "JSHSHIR 14 da raqamdan iborat bo'lishi kerak");
            }
            AuthUser user = modelMapper.map(userRequest, AuthUser.class);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return new ApiResponse(true, "Successful");
        } catch (RuntimeException e) {
            return new ApiResponse(false, e.getMessage());
        }
    }

    public JwtResponse login(LoginRequest loginRequest) {
        AuthUser user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RecordNotFoundException("Username or password incorrect"));
        checkPassword(loginRequest.getPassword(), user.getPassword());
        String token = "Bearer " + jwtService.generateToken(user);
        return new JwtResponse(
                token,
                true,
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getRoles());
    }

    private void checkPassword(String dtoPassword, String daoPassword) {
        if (!passwordEncoder.matches(dtoPassword, daoPassword)) {
            throw new RecordNotFoundException("Username or password incorrect");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
