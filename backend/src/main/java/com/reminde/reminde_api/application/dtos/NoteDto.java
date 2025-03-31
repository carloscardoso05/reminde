package com.reminde.reminde_api.application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class NoteDto {
    private UUID id;
    @NotNull
    private UUID ownerId;
    @NotBlank
    private String title = "";
    @NotNull
    private String content = "";
    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();
    @NotNull
    private LocalDateTime updatedAt = LocalDateTime.now();
    private LocalDateTime dueDate;
    private final List<String> tags = new ArrayList<>();
    private final List<LocalDateTime> reminders = new ArrayList<>();
}
