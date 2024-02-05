package com.example.uzrailways.service;

import com.example.uzrailways.domain.response.KadrResponse;
import com.example.uzrailways.repository.KadrRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CadreService {
    private final PhotoService photoService;
    private final KadrRepository kadrRepository;
    private final ModelMapper modelMapper;

    public ResponseEntity<KadrResponse> add(String stringKadrDTO, MultipartFile photo) {

    }
}
