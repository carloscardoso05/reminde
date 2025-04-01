package com.reminde.reminde_api.application.port.in;

import com.reminde.reminde_api.application.dto.CreateNoteRequest;
import com.reminde.reminde_api.application.dto.NoteDto;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteUseCase {
    NoteDto createNote(CreateNoteRequest request);
    Optional<NoteDto> getNote(UUID id);
    List<NoteDto> getNotesByUser(UUID userId);
    void deleteNote(UUID id);
} 