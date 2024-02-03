package com.example.uzrailways.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "TalabNomalar")
@Getter
@Setter
public class Talabnomalar extends BaseEntity {
    @ManyToOne
    public AuthUser kimga;
    @ManyToOne
    public AuthUser jonatuvchi;
    @ManyToOne
    public AuthUser tasdiqlovchi;
    @OneToMany
    public List<Mahsulot> soralganMahsulotlar;
    @OneToMany
    public List<Mahsulot> beriladiganMahsulotlar;
    public StatusTalabnoma status;
}
