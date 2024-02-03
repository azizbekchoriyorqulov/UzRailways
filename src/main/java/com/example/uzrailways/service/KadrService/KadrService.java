package com.example.uzrailways.service.KadrService;

import com.example.uzrailways.entity.Kadr;
import com.example.uzrailways.entity.Photo;
import com.example.uzrailways.entity.StatusKadr;
import com.example.uzrailways.model.KadrDTO;
import com.example.uzrailways.repository.KadrRepository;
import com.example.uzrailways.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class KadrService
{
    private final PhotoService photoService;
    private final KadrRepository kadrRepository;

    public ResponseEntity<?> add(KadrDTO kadrDTO, MultipartFile photo)
    {
        Kadr kadr = new Kadr();
        kadr.setFullName(kadrDTO.getFullName());
        kadr.setSectionNumber(kadrDTO.getSectionNumber());
        kadr.setLavozim(kadrDTO.getLavozim());
        kadr.setPhoneNumber(kadrDTO.getPhoneNumber());
        kadr.setJshshr(kadrDTO.getJshshr());
        kadr.setStatus( StatusKadr.valueOf(kadrDTO.getStatus()) );

        try
        {
            Date oxirgiTibbiyKorik = new SimpleDateFormat("dd-mm-yyyy").parse(kadrDTO.getOxirgiTibbiyKorik());
            Date keyingiTibbiyKorik = new SimpleDateFormat("dd-mm-yyyy").parse(kadrDTO.getKeyingiTibbiyKorik());
            kadr.setOxirgiTibbiyKorik(oxirgiTibbiyKorik);
            kadr.setKeyingiTibbiyKorik(keyingiTibbiyKorik);
        } catch (ParseException e)
        {
            throw new RuntimeException(e+" DATE FORMAT TO\'G\'RI KEMADII ");
        }

        Photo photoOfKadr = photoService.savePhotoToServer(photo);
        kadr.setRasm(photoOfKadr);

        Kadr savedKadr = kadrRepository.save(kadr);
        return ResponseEntity.ok().body(savedKadr);
    }

}
