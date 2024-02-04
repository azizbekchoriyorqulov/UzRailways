package com.example.uzrailways.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CadreResponse {
    private String fullName;
    private String sectionNumber;
    private String Postion;
    private String lastMedicalCheck;
    private String nextMedicalCheck;
    private String phoneNumber;
    private String jshshr;
    private String status;
    private String photoHttpUrl;
    private String wordFileHttpUrl;
}
