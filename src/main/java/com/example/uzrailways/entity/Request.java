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
//talabnoma zayavka
public class Request extends BaseEntity {
    //qabul qiluvchi
    @ManyToOne
    public AuthUser receptive;
    //jonatuvchi
    @ManyToOne
    public AuthUser sender;
    //tasdiqlovchi
    @ManyToOne
    public AuthUser affirmative;
    //soralgan mahsulot
    @OneToMany
    public List<Product> requestedProduct;
    //beriladiganMahsulotlar
    @OneToMany
    public List<Product> givenProduct;
    public StatusRequest status;
}
