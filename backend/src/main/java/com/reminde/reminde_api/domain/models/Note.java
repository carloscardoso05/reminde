package com.reminde.reminde_api.domain.models;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Note {
    private final UUID id;
    @NotNull
    private final UUID ownerId;
    @NotNull
    private final String title;
    @NotNull
    private final String content;
    @NotNull
    private final LocalDateTime createdAt;
    @NotNull
    private final LocalDateTime updatedAt;
    private final LocalDateTime dueDate;
    private final List<String> tags = new ArrayList<>();
    private final List<LocalDateTime> reminders = new ArrayList<>();


    @Builder
    public Note(UUID id,
                @NotNull String title,
                @NotNull String content,
                @NotNull LocalDateTime createdAt,
                @NotNull LocalDateTime updatedAt,
                LocalDateTime dueDate,
                List<String> tags,
                List<LocalDateTime> reminders,
                @Nonnull UUID ownerId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dueDate = dueDate;
        this.ownerId = ownerId;
        this.tags.addAll(tags);
        this.reminders.addAll(reminders);
    }
}
