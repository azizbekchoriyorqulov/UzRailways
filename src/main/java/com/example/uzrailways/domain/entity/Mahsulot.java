package com.example.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Mahsulotlar")
@Getter
@Setter

public class Mahsulot extends BaseEntity{
    public String name;
    public String olchovBirligi;
    public  Double miqdor;
}
