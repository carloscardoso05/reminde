package com.reminde.reminde_api.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<NoteEntity> notes;
}
