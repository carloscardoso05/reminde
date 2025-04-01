package com.reminde.reminde_api.application.service;

import com.reminde.reminde_api.application.port.out.NoteRepository;
import com.reminde.reminde_api.domain.model.Note;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CreateNoteService {
    private final NoteRepository noteRepository;

    public CreateNoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(String title, String content, LocalDate dueDate, List<String> tags, List<LocalDateTime> reminders) {
        Note note = new Note(
            UUID.randomUUID(),
            title,
            content,
            dueDate,
            tags,
            reminders
        );
        return noteRepository.save(note);
    }
} 