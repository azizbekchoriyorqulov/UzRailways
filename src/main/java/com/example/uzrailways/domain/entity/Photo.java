package com.example.uzrailways.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "photo")
@Getter
@Setter
public class Photo extends BaseEntity
{
    public String fullName;
    public String httpUrl;
    public String fileUrl;
    public String photoType;
    public Long size;
}