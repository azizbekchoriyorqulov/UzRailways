package com.example.uzrailways.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KadrDTO
{
    private String fullName;
    private String sectionNumber;
    private String lavozim;
    private String oxirgiTibbiyKorik;
    private String keyingiTibbiyKorik;
    private String phoneNumber;
    private String jshshr;
    private String status;
    private String photoHttpUrl;
    private String wordFileHttpUrl;
}