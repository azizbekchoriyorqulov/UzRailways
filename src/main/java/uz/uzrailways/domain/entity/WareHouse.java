package uz.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "WareHouse")
@Getter
@Setter
public class WareHouse extends BaseEntity{
    private AuthUser manager;
    private List<Product> products;


}
