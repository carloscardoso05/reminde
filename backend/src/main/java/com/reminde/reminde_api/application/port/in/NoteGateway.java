package com.reminde.reminde_api.application.port.in;

import com.reminde.reminde_api.application.dto.CreateNoteRequest;
import com.reminde.reminde_api.application.dto.NoteDto;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteGateway {
    NoteDto createNote(CreateNoteRequest request);
    Optional<NoteDto> getNote(UUID id);
    List<NoteDto> getNotesByOwner(UUID userId);
    void deleteNote(UUID id);
} 