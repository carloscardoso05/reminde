package com.reminde.reminde_api.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tags")
@Data
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToOne
    private UserEntity owner;

    @ManyToMany(mappedBy = "tags")
    private List<NoteEntity> notes;
}
