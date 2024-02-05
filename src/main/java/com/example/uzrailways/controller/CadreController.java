package com.example.uzrailways.controller;

import com.example.uzrailways.domain.response.CadreResponse;
import com.example.uzrailways.domain.response.CadreResponse;
import com.example.uzrailways.domain.response.KadrResponse;
import com.example.uzrailways.service.CadreService;
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
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cadre")
public class CadreController {
    private final CadreService cadreService;
    private final PhotoService photoService;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok().body("Test path OK Bro...");
    }

    @PostMapping(value = "/add" , consumes = {MediaType.APPLICATION_JSON_VALUE ,
            MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<KadrResponse> addKadr(@RequestPart("cadreDTO")String stringKadrDTO ,
                                                @RequestPart("photo")MultipartFile photo)
    {
        return cadreService.add(stringKadrDTO , photo);
    }

    @GetMapping("/image/{photoId}")
    public ResponseEntity<?> viewPhoto(@PathVariable UUID photoId) {
        String fileUrlById = photoService.findFileUrlById(photoId);
        try {

            Resource resource = new UrlResource(new File(fileUrlById).toURI());
            // Check if the file exists
            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

//    @GetMapping("/list")
//    public ResponseEntity<?> getListCadre(
//            @RequestParam(value = "page", defaultValue = "0") Integer pageNum,
//            @RequestParam(value = "size", defaultValue = "100") Integer size,
//            @RequestParam(value = "sortBy", defaultValue = "fullName") String sortBy,
//            @RequestParam(value = "asc", defaultValue = "-1") String asc) {
//        List<CadreResponse> listKadrDTO = cadreService.getListKadrAsDTO(pageNum, size, sortBy, asc);
//        return ResponseEntity.ok().body(new CadreResponse(true, "List kadr's", listKadrDTO));
//    }
}



