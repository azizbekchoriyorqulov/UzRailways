package com.example.uzrailways.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "products")
public class Product extends BaseEntity {
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType type;
    @Column
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "seh_id")
    private Seh seh;
}
