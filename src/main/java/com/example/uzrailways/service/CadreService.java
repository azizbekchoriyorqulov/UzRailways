package com.example.uzrailways.service;

import com.example.uzrailways.domain.entity.Cadre;
import com.example.uzrailways.domain.entity.Photo;
import com.example.uzrailways.domain.model.CadreDTO;
import com.example.uzrailways.domain.response.KadrResponse;
import com.example.uzrailways.mapper.CadreMapper;
import com.example.uzrailways.repository.KadrRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadreService {
    private final PhotoService photoService;
    private final KadrRepository kadrRepository;
    private final ModelMapper modelMapper;
    private final CadreMapper cadreMapper;

    public ResponseEntity<KadrResponse> add(String stringKadrDTO, MultipartFile photo)
    {
        System.out.println("stringKadrDTO = " + stringKadrDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        CadreDTO cadreDTO;
        try {
            cadreDTO = objectMapper.readValue(stringKadrDTO, CadreDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e+" JSON DAN KADRDTO YASASHDA MUAMMO....");
        }

        Cadre cadre = cadreMapper.mapToEntity(cadreDTO);

        Photo photoOfKadr = photoService.savePhotoToServer(photo);
        cadre.setPhoto(photoOfKadr);

        Cadre savedKadr = kadrRepository.save(cadre);

        return ResponseEntity.ok().body(new KadrResponse(true,"Succesfully saved",cadreMapper.mapToDTO(savedKadr)));

    }

    public List<CadreDTO> getListCadreAsDTO(Integer pageNum, Integer size, String sortBy, String asc)
    {
        Pageable pageable;
        if (asc.equals("-1"))
            pageable = PageRequest.of(pageNum,size, Sort.by(Sort.Direction.DESC,sortBy) );
        else
            pageable = PageRequest.of(pageNum,size, Sort.by(Sort.Direction.ASC,sortBy) );

        List<Cadre> dtoList = kadrRepository.findAll(pageable).getContent();
        return cadreMapper.mapCadreToDtoList(dtoList);
    }
}
