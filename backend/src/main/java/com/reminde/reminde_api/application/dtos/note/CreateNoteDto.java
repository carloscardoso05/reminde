package com.reminde.reminde_api.application.dtos.note;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNoteDto {
    @NotNull(message = "Owner ID is required")
    private UUID ownerId;
    
    @NotBlank(message = "Title cannot be empty")
    @Length(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    
    @NotNull(message = "Content is required")
    @Length(max = 5000, message = "Content cannot exceed 5000 characters")
    @Builder.Default
    private String content = "";
    
    @Future(message = "Due date must be in the future")
    private LocalDateTime dueDate;
    
    @Size(max = 10, message = "Cannot have more than 10 tags")
    @Builder.Default
    private List<String> tags = new ArrayList<>();
} 