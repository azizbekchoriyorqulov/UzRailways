package com.example.uzrailways.service;

import com.example.uzrailways.domain.entity.Cadre;
import com.example.uzrailways.domain.entity.Photo;
import com.example.uzrailways.domain.model.KadrDTO;
import com.example.uzrailways.domain.response.KadrResponse;
import com.example.uzrailways.mapper.CadreMapper;
import com.example.uzrailways.repository.KadrRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final CadreMapper cadreMapper;

    public ResponseEntity<KadrResponse> add(String stringKadrDTO, MultipartFile photo) {
        System.out.println("stringKadrDTO = " + stringKadrDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        KadrDTO kadrDTO ;
        try {
            kadrDTO = objectMapper.readValue(stringKadrDTO, KadrDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e+" JSON DAN KADRDTO YASASHDA MUAMMO....");
        }

        Cadre cadre = cadreMapper.mapToEntity(kadrDTO);

        Photo photoOfKadr = photoService.savePhotoToServer(photo);
        kadr.setRasm(photoOfKadr);

        Kadr savedKadr = kadrRepository.save(kadr);

        return ResponseEntity.ok().body(new KadrResponse(true,"Succesfully saved",kadrMapper.mapToDTO(savedKadr)));

    }
}
