package uz.uzrailways.domain.entity;

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
    public String managerName;
    @OneToOne
    public  AuthUser managerSeh;
    @OneToMany
    public List<Cadre> cadres;
}
