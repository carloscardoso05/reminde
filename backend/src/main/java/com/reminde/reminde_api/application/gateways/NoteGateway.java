package com.reminde.reminde_api.application.gateways;

import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.application.dtos.note.CreateNoteDto;
import com.reminde.reminde_api.domain.models.Note;

import java.util.List;
import java.util.UUID;

public interface NoteGateway {
    List<Note> getNotes();

    Note createNote(CreateNoteDto createNoteDto);

    Note updateNote(NoteDto note);

    Note getNoteById(UUID id);

    void deleteNoteById(UUID id);

    List<Note> getNotesByOwnerId(UUID ownerId);
}
