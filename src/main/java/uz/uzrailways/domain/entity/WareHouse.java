package uz.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "WareHouse")
@Getter
@Setter
public class WareHouse extends BaseEntity{
    @OneToOne
    private AuthUser managerWareHouse;
    @OneToMany
    private List<Product> products;


}
