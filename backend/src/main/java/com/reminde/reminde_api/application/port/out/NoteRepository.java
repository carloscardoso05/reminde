package com.reminde.reminde_api.application.port.out;

import com.reminde.reminde_api.domain.model.Note;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteRepository {
    Note save(Note note);
    Optional<Note> findById(UUID id);
    List<Note> findByOwnerId(UUID ownerId);
    void deleteById(UUID id);
} 