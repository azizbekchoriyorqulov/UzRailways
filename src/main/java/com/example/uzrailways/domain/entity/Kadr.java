package com.example.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Kadr")
@Getter
@Setter
public class Kadr extends BaseEntity
{
    public String fullName;
    @OneToOne
    public Photo rasm;
    public String bolimRaqami;
    public String lavozim;
    public Date oxirgiTibbiyKorik;
    public Date keyingiTibbiyKorik;
    public String phoneNumber;
    public String jshshr;
    @Enumerated(value = EnumType.STRING)
    public StatusKadr status;
    @OneToOne
    public WordDoc wordDoc;

}