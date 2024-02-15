package uz.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WordDoc extends BaseEntity{
    public String fullName;
    public String httpUrl;
    public String fileUrl;
}
