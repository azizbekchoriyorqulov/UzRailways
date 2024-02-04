package com.example.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "product_types")
public class ProductType extends BaseEntity {
    private String name;
}
