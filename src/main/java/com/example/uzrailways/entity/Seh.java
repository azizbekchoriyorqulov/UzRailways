package com.example.uzrailways.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "seh")
@Getter
@Setter
public class Seh extends BaseEntity{
    public String sehNomi;
    public String ManagerName;
    @OneToOne
    public  User ManagerSeh;
    @OneToMany
    public List<Mahsulot> Mahsulotlar;


}
