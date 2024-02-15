package uz.uzrailways.domain.entity;

import uz.uzrailways.domain.enums.CadreStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "cadres")
@Getter
@Setter
public class Cadre extends BaseEntity {
    @Column
    public String fullName;
    @OneToOne
    public Photo photo;
    public String sectionNumber;
    public String position;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date lastMedicalCheck;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date nextMedicalCheck;
    public String phoneNumber;
    public String jshshr;
    @Enumerated(value = EnumType.STRING)
    public CadreStatus status;
    @OneToOne
    public WordDoc wordDoc;
}