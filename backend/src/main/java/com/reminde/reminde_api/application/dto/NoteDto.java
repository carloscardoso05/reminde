package com.reminde.reminde_api.application.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record NoteDto(
    UUID id,
    UUID ownerId,
    String title,
    String content,
    LocalDate dueDate,
    List<String> tags,
    List<LocalDateTime> reminders
) {} 