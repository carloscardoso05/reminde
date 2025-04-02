package com.reminde.reminde_api.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreateNoteRequest(
    @NotBlank(message = "Title is required")
    String title,
    @NotBlank(message = "Content is required")
    String content,
    @NotNull(message = "Due date is required")
    LocalDate dueDate,
    List<String> tags,
    List<LocalDateTime> reminders,
    @NotNull(message = "Owner ID is required")
    UUID ownerId
) {} 