package com.reminde.reminde_api.application.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class NoteDto {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime dueDate ;
    private final List<Integer> tagsIds = new ArrayList<>();
    private final List<LocalDateTime> reminders = new ArrayList<>();
}
