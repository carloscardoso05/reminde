package com.reminde.reminde_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Note {
    private final UUID id;
    private final UUID ownerId;
    private final String title;
    private final String content;
    private final LocalDate dueDate;
    private final List<String> tags;
    private final List<LocalDateTime> reminders;
} 