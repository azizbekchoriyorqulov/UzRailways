package com.example.uzrailways.mapper;
import com.example.uzrailways.entity.Kadr;
import com.example.uzrailways.entity.StatusKadr;
import com.example.uzrailways.model.KadrDTO;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KadrMapper {
    public  KadrDTO mapToDTO(Kadr kadr)
    {
        KadrDTO kadrDTO = new KadrDTO();
        kadrDTO.setFullName(kadr.getFullName());
        kadrDTO.setSectionNumber(kadr.getSectionNumber());
        kadrDTO.setPostion(kadr.getPosition());
        kadrDTO.setLastMedicalCheck(formatDate(kadr.getLastMedicalCheck()));
        kadrDTO.setNextMedicalCheck(formatDate(kadr.getNextMedicalCheck()));
        kadrDTO.setPhoneNumber(kadr.getPhoneNumber());
        kadrDTO.setJshshr(kadr.getJshshr());
        kadrDTO.setStatus(kadr.getStatus().toString());
        kadrDTO.setPhotoHttpUrl( "http://localhost:8080/kadr/image/"+kadr.getPhoto().getId() );
        return kadrDTO;
    }

    public  Kadr mapToEntity(KadrDTO kadrDTO) {
        Kadr kadr = new Kadr();
        kadr.setFullName(kadrDTO.getFullName());
        kadr.setSectionNumber(kadrDTO.getSectionNumber());
        kadr.setPosition(kadrDTO.getPostion());
        kadr.setLastMedicalCheck(parseDate(kadrDTO.getLastMedicalCheck()));
        kadr.setNextMedicalCheck(parseDate(kadrDTO.getNextMedicalCheck()));
        kadr.setPhoneNumber(kadrDTO.getPhoneNumber());
        kadr.setJshshr(kadrDTO.getJshshr());
        kadr.setStatus(StatusKadr.valueOf(kadrDTO.getStatus()));
        return kadr;
    }

    public List<KadrDTO> mapKadrListToDTOList(List<Kadr> kadrList)
    {
        return kadrList.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private  String formatDate(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        return date != null ? dateFormat.format(date) : null;
    }

    private  Date parseDate(String dateStr)
    {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return dateStr != null ? dateFormat.parse(dateStr) : null;
        } catch (ParseException e) {
            throw new RuntimeException("Date format cast qilishda xatolik");
        }
    }
}
