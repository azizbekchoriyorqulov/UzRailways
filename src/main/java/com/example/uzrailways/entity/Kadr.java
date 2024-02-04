package com.example.uzrailways.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "Kadr")
@Getter
@Setter
public class Kadr extends BaseEntity
{
    public String fullName;
    @OneToOne
    public Photo photo;
    public String sectionNumber;
    public String position;
    public Date lastMedicalCheck;
    public Date nextMedicalCheck;
    public String phoneNumber;
    public String jshshr;
    @Enumerated(value = EnumType.STRING)
    public StatusKadr status;
    @OneToOne
    public WordDoc wordDoc;
}