package com.example.uzrailways.mapper;

import com.example.uzrailways.domain.entity.Cadre;
import com.example.uzrailways.domain.model.CadreDTO;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CadreMapper {
    public CadreDTO mapToDTO(Cadre kadr)
    {
        CadreDTO cadreDTO = new CadreDTO();
        cadreDTO.setFullName(kadr.getFullName());
        cadreDTO.setBolimRaqami(kadr.getBolimRaqami());
        cadreDTO.setLavozim(kadr.getLavozim());
        cadreDTO.setOxirgiTibbiyKorik(formatDate(kadr.getOxirgiTibbiyKorik()));
        cadreDTO.setKeyingiTibbiyKorik(formatDate(kadr.getKeyingiTibbiyKorik()));
        cadreDTO.setPhoneNumber(kadr.getPhoneNumber());
        cadreDTO.setJshshr(kadr.getJshshr());
        cadreDTO.setStatus(kadr.getStatus().toString());
        cadreDTO.setPhotoHttpUrl( "http://localhost:8080/kadr/image/"+kadr.getRasm().getId() );
        return cadreDTO;
    }

    public  Cadre mapToEntity(CadreDTO cadreDTO) {
        Cadre cadre = new Cadre();
        cadre.setFullName(cadreDTO.getFullName());
        cadre.setBolimRaqami(cadreDTO.getBolimRaqami());
        cadre.setLavozim(cadreDTO.getLavozim());
        cadre.setOxirgiTibbiyKorik(parseDate(cadreDTO.getOxirgiTibbiyKorik()));
        cadre.setKeyingiTibbiyKorik(parseDate(cadreDTO.getKeyingiTibbiyKorik()));
        cadre.setPhoneNumber(cadreDTO.getPhoneNumber());
        cadre.setJshshr(cadreDTO.getJshshr());
        cadre.setStatus(StatusKadr.valueOf(cadreDTO.getStatus()));
        return cadre;
    }

    public List<CadreDTO> mapKadrListToDTOList(List<Cadre> cadreList)
    {
        return cadreList.stream()
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
