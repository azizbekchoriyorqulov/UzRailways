package com.example.uzrailways.domain.entity;

import com.example.uzrailways.domain.enums.StatusRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "requirements")
@Getter
@Setter
//talabnoma zayavka
public class Requirement extends BaseEntity {
    //qabul qiluvchi
    @ManyToOne
    public AuthUser receiver;
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
