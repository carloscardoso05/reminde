package com.reminde.reminde_api.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity {
    @Id
    private UUID id;
    
    private String title;
    private String content;
    private LocalDate dueDate;
    
    @ElementCollection
    @CollectionTable(name = "note_tags", joinColumns = @JoinColumn(name = "note_id"))
    @Column(name = "tag")
    private List<String> tags;
    
    @ElementCollection
    @CollectionTable(name = "note_reminders", joinColumns = @JoinColumn(name = "note_id"))
    @Column(name = "reminder")
    private List<LocalDateTime> reminders;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
} 