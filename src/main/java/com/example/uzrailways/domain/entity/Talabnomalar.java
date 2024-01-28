package com.example.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "TalabNomalar")
@Getter
@Setter
public class Talabnomalar extends BaseEntity {
    @ManyToOne
    public User kimga;
    @ManyToOne
    public User jonatuvchi;
    @ManyToOne
    public User tasdiqlovchi;
    @OneToMany
    public List<Mahsulot> soralganMahsulotlar;
    @OneToMany
    public List<Mahsulot> beriladiganMahsulotlar;
    public StatusTalabnoma status;
}
