package com.example.uzrailways.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Mahsulotlar")
@Getter
@Setter

public class Product extends BaseEntity{
    public String name;
    //olchov birligi

    public String unitOfMeasure;
    //miqdor
    public  Double amount;
}
