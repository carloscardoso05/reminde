package com.reminde.reminde_api.application.validators;

import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.application.dtos.note.CreateNoteDto;
import com.reminde.reminde_api.application.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class NoteValidator {
    
    public void validateNote(NoteDto note) {
        validateDueDate(note.getDueDate());
        validateReminders(note.getReminders(), note.getDueDate());
        validateTags(note.getTags());
    }
    
    public void validateCreateNote(CreateNoteDto note) {
        validateDueDate(note.getDueDate());
        validateTags(note.getTags());
    }
    
    private void validateDueDate(LocalDateTime dueDate) {
        if (dueDate != null && dueDate.isBefore(LocalDateTime.now())) {
            throw new ValidationException("Due date must be in the future");
        }
    }
    
    private void validateReminders(List<LocalDateTime> reminders, LocalDateTime dueDate) {
        if (reminders == null || reminders.isEmpty()) {
            return;
        }
        
        LocalDateTime now = LocalDateTime.now();
        for (LocalDateTime reminder : reminders) {
            if (reminder.isBefore(now)) {
                throw new ValidationException("Reminder time must be in the future");
            }
            if (dueDate != null && reminder.isAfter(dueDate)) {
                throw new ValidationException("Reminder time cannot be after the due date");
            }
        }
    }
    
    private void validateTags(List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            return;
        }
        
        for (String tag : tags) {
            if (tag == null || tag.trim().isEmpty()) {
                throw new ValidationException("Tags cannot be empty");
            }
            if (tag.length() > 20) {
                throw new ValidationException("Tag length cannot exceed 20 characters");
            }
        }
    }
} 