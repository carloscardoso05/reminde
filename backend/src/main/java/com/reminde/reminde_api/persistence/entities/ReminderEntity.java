package com.reminde.reminde_api.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reminders")
@Data
public class ReminderEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private LocalDateTime dateTime;

    @ManyToOne
    private NoteEntity note;
}
