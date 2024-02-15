package uz.uzrailways.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadreDTO
{
    private String fullName;
    private String sectionNumber;
    private String position;
    private String lastMedicalCheck;
    private String nextMedicalCheck;
    private String phoneNumber;
    private String jshshr;
    private String status;
    private String photoHttpUrl;
    private String wordFileHttpUrl;
}
