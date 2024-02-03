package com.example.uzrailways.controller;


import com.example.uzrailways.model.KadrDTO;
import com.example.uzrailways.service.KadrService.KadrService;
import com.example.uzrailways.service.PhotoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.MalformedURLException;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kadr")
public class KadrController
{
    private  final KadrService kadrService ;
    private final PhotoService photoService;

    @GetMapping("/test")
    public ResponseEntity<?> test()
    {
        return  ResponseEntity.ok().body("Test path OK Bro...") ;
    }

    @PostMapping(value = "/add" , consumes = {MediaType.APPLICATION_JSON_VALUE ,
                                                 MediaType.MULTIPART_FORM_DATA_VALUE})
    public  ResponseEntity<?> addKadr(@RequestPart("kadrDTO")String stringKadrDTO , @RequestPart("photo") MultipartFile photo)
    {
        System.out.println("stringKadrDTO = " + stringKadrDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        KadrDTO kadrDTO = null;
        try
        {
          kadrDTO = objectMapper.readValue(stringKadrDTO, KadrDTO.class);
        } catch (JsonProcessingException e) {
        throw new RuntimeException(e+" JSON DAN KADRDTO YASASHDA MUAMMO...");
    }
        return kadrService.add(kadrDTO , photo);
    }

    @GetMapping("/image/{photoId}")
    public ResponseEntity viewPhoto(@PathVariable UUID photoId)
    {
        String fileUrlById = photoService.findFileUrlById(photoId);
        try {

            Resource resource = new UrlResource(new File(fileUrlById).toURI());
            // Check if the file exists
            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
