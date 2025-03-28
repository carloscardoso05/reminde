package com.reminde.reminde_api.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tags")
@Data
public class TagEntity {
    @Id
    private String name;
}
