package uz.uzrailways.mapper;

import uz.uzrailways.domain.entity.Cadre;
import uz.uzrailways.domain.enums.CadreStatus;
import uz.uzrailways.domain.model.CadreDTO;
import uz.uzrailways.exeption.DateFormatCastException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CadreMapper {
    public CadreDTO mapToDTO(Cadre cadre)
    {
        CadreDTO cadreDTO = new CadreDTO();
        cadreDTO.setFullName(cadre.getFullName());
        cadreDTO.setSectionNumber(cadre.getSectionNumber());
        cadreDTO.setPosition(cadre.getPosition());
        cadreDTO.setLastMedicalCheck(formatDate(cadre.getLastMedicalCheck()));
        cadreDTO.setNextMedicalCheck(formatDate(cadre.getNextMedicalCheck()));
        cadreDTO.setPhoneNumber(cadre.getPhoneNumber());
        cadreDTO.setJshshr(cadre.getJshshr());
        cadreDTO.setStatus(cadre.getStatus().toString());
        cadreDTO.setPhotoHttpUrl( "http://localhost:8080/kadr/image/"+cadre.getPhoto().getId() );
        return cadreDTO;
    }

    public  Cadre mapToEntity(CadreDTO cadreDTO) {
        Cadre cadre = new Cadre();
        cadre.setFullName(cadreDTO.getFullName());
        cadre.setSectionNumber(cadreDTO.getSectionNumber());
        cadre.setPosition(cadreDTO.getPosition());
        cadre.setLastMedicalCheck(parseDate(cadreDTO.getLastMedicalCheck()));
        cadre.setNextMedicalCheck(parseDate(cadreDTO.getNextMedicalCheck()));
        cadre.setPhoneNumber(cadreDTO.getPhoneNumber());
        cadre.setJshshr(cadreDTO.getJshshr());
        cadre.setStatus(CadreStatus.valueOf(cadreDTO.getStatus()));
        return cadre;
    }

    public List<CadreDTO> mapCadreToDtoList(List<Cadre> cadreList)
    {
        return cadreList.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private  String formatDate(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return date != null ? dateFormat.format(date) : null;
    }

    private  Date parseDate(String dateStr)
    {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateStr != null ? dateFormat.parse(dateStr) : null;
        } catch (ParseException e) {
            throw new DateFormatCastException("Error while casting date format, Expected format:\"yyyy-MM-dd\" , received:"+dateStr);
        }
    }
}
