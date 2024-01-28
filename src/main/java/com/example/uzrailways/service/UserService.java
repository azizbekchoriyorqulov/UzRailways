package com.example.uzrailways.service;

import com.example.uzrailways.domain.entity.BaseEntity;
import com.example.uzrailways.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService  {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;


}
