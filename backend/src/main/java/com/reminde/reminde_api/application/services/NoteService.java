package com.reminde.reminde_api.application.services;

import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.application.gateways.NoteGateway;
import com.reminde.reminde_api.domain.models.Note;

import java.util.List;
import java.util.UUID;

public class NoteService implements NoteGateway {
    @Override
    public Note createNote(NoteDto note) {
        return null;
    }

    @Override
    public Note updateNote(NoteDto note) {
        return null;
    }

    @Override
    public Note getNoteById(UUID id) {
        return null;
    }

    @Override
    public void deleteNoteById(UUID id) {

    }

    @Override
    public List<Note> getNotesByUserId(UUID userId) {
        return List.of();
    }
}
