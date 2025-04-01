package com.reminde.reminde_api.application.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteDto {
    private UUID id;
    
    @NotNull(message = "Owner ID is required")
    private UUID ownerId;
    
    @NotBlank(message = "Title cannot be empty")
    @Length(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    
    @NotNull(message = "Content is required")
    @Length(max = 5000, message = "Content cannot exceed 5000 characters")
    @Builder.Default
    private String content = "";
    
    @NotNull(message = "Creation date is required")
    @PastOrPresent(message = "Creation date cannot be in the future")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @NotNull(message = "Update date is required")
    @PastOrPresent(message = "Update date cannot be in the future")
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    @Future(message = "Due date must be in the future")
    private LocalDateTime dueDate;
    
    @Size(max = 10, message = "Cannot have more than 10 tags")
    @Builder.Default
    private List<String> tags = new ArrayList<>();
    
    @Size(max = 5, message = "Cannot have more than 5 reminders")
    @Builder.Default
    private List<LocalDateTime> reminders = new ArrayList<>();
}
