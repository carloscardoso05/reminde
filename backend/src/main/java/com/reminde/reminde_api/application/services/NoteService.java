package com.reminde.reminde_api.application.services;

import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.application.exceptions.ResourceNotFoundException;
import com.reminde.reminde_api.application.gateways.NoteGateway;
import com.reminde.reminde_api.domain.models.Note;
import com.reminde.reminde_api.facades.mappers.NoteMapper;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import com.reminde.reminde_api.persistence.repositories.NoteEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService implements NoteGateway {
    private final NoteEntityRepository noteEntityRepository;
    private final NoteMapper noteConverter;

    public NoteService(NoteEntityRepository noteEntityRepository, NoteMapper noteConverter) {
        this.noteEntityRepository = noteEntityRepository;
        this.noteConverter = noteConverter;
    }

    @Override
    public List<Note> getNotes() {
        return noteEntityRepository.findAll()
                .stream()
                .map(noteConverter::modelFromEntity)
                .toList();
    }

    @Override
    public Note createNote(NoteDto note) {
        final NoteEntity noteEntity = noteConverter.entityFromDto(note);
        noteEntity.setId(null);
        return noteConverter.modelFromEntity(noteEntityRepository.save(noteEntity));
    }

    @Override
    public Note updateNote(NoteDto note) {
        final NoteEntity noteEntity = noteConverter.entityFromDto(note);
        noteEntityRepository.findById(noteEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException(Note.class, note.getId()));
        return noteConverter.modelFromEntity(noteEntityRepository.save(noteEntity));
    }

    @Override
    public Note getNoteById(UUID id) throws ResourceNotFoundException {
        return noteConverter.modelFromEntity(noteEntityRepository.findById(id)
                                                     .orElseThrow(() -> new ResourceNotFoundException(Note.class, id)));
    }

    @Override
    public void deleteNoteById(UUID id) {
        noteEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Note.class, id));
        noteEntityRepository.deleteById(id);
    }

    @Override
    public List<Note> getNotesByOwnerId(UUID ownerId) {
        return noteEntityRepository.findAllByOwnerId(ownerId)
                .stream()
                .map(noteConverter::modelFromEntity)
                .toList();
    }
}
