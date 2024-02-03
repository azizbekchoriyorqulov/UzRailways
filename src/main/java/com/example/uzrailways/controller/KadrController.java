package com.example.uzrailways.controller;

import com.example.uzrailways.model.KadrDTO;

import com.example.uzrailways.model.KadrResponse;


import com.example.uzrailways.service.KadrService.KadrService;
import com.example.uzrailways.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
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
    public ResponseEntity<KadrResponse> addKadr(@RequestPart("kadrDTO")String stringKadrDTO ,
                                                 @RequestPart("photo")MultipartFile photo)

    {
        return kadrService.add(stringKadrDTO , photo);
    }

    @GetMapping("/image/{photoId}")

    public ResponseEntity<?> viewPhoto(@PathVariable UUID photoId)
    {
        return photoService.viewKadrPhoto(photoId);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<KadrResponse> editKadr(@PathVariable UUID id , @RequestBody KadrDTO updateTo )
    {
//        return kadrService.update(id,updateTo) ;
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<KadrResponse> deleteKadr(@PathVariable UUID id)
    {
//        return kadrService.delete(id);
        return null;
    }


    @GetMapping("/list")
    public ResponseEntity<?> getListKadr(
            @RequestParam(value = "page", defaultValue = "0")  Integer pageNum,
            @RequestParam(value = "size", defaultValue = "100") Integer size ,
            @RequestParam(value = "sortBy", defaultValue = "fullName") String sortBy ,
            @RequestParam(value = "asc", defaultValue = "-1") String asc )
    {
        List<KadrDTO> listKadrDTO = kadrService.getListKadrAsDTO(pageNum, size, sortBy, asc);
        return ResponseEntity.ok().body(new KadrResponse(true,"List kadr's",listKadrDTO));
    }

}
