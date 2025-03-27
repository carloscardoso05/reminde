package com.reminde.reminde_api.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Note {
    private final UUID id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDateTime dueDate;
    private final List<Tag> tags = new ArrayList<>();
    private final List<LocalDateTime> reminders = new ArrayList<>();

    @Builder
    public Note(UUID id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime dueDate, @Singular List<Tag> tags, @Singular List<LocalDateTime> reminders) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dueDate = dueDate;
        this.tags.addAll(tags);
        this.reminders.addAll(reminders);
    }
}
