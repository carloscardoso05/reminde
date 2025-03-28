package com.reminde.reminde_api.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notes")
@Data
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime dueDate;

    @ManyToMany
    private List<TagEntity> tags = new ArrayList<>();

    @OneToMany(mappedBy = "note")
    private List<ReminderEntity> reminders = new ArrayList<>();

    @ManyToOne
    private UserEntity owner;
}
