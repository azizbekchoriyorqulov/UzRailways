package com.example.uzrailways.service;

import com.example.uzrailways.repository.KadrRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadreService {
    private final PhotoService photoService;
    private final KadrRepository kadrRepository;
    private final ModelMapper modelMapper;

}
