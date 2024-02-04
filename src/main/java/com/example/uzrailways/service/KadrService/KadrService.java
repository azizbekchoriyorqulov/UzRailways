package com.example.uzrailways.service.KadrService;

import com.example.uzrailways.entity.Kadr;
import com.example.uzrailways.entity.Photo;

import com.example.uzrailways.mapper.KadrMapper;
import com.example.uzrailways.model.KadrDTO;
import com.example.uzrailways.model.KadrResponse;

import com.example.uzrailways.repository.KadrRepository;

import com.example.uzrailways.service.PhotoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KadrService
{
    private final PhotoService photoService;
    private final KadrRepository kadrRepository;
    private final KadrMapper kadrMapper ;


    public ResponseEntity<KadrResponse> add(String stringKadrDTO, MultipartFile photo)
    {
        System.out.println("stringKadrDTO = " + stringKadrDTO);

        ObjectMapper objectMapper = new ObjectMapper();
        KadrDTO kadrDTO ;
        try {
            kadrDTO = objectMapper.readValue(stringKadrDTO, KadrDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e+" JSON DAN KADRDTO YASASHDA MUAMMO....");
        }

        Kadr kadr = kadrMapper.mapToEntity(kadrDTO);

        Photo photoOfKadr = photoService.savePhotoToServer(photo);
        kadr.setPhoto(photoOfKadr);

        Kadr savedKadr = kadrRepository.save(kadr);

        return ResponseEntity.ok().body(new KadrResponse(true,"Succesfully saved",kadrMapper.mapToDTO(savedKadr)));
    }

    public List<KadrDTO> getListKadrAsDTO(Integer pageNum, Integer size, String sortBy, String asc)
    {
        Pageable pageable;
        if (asc.equals("-1"))
            pageable = PageRequest.of(pageNum,size, Sort.by(Sort.Direction.DESC,sortBy) );
        else
            pageable = PageRequest.of(pageNum,size, Sort.by(Sort.Direction.ASC,sortBy) );

        List<Kadr> kadrList = kadrRepository.findAll(pageable).getContent();
        return kadrMapper.mapKadrListToDTOList(kadrList);
    }
}
