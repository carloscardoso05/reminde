package com.reminde.reminde_api.application.services;

import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.application.dtos.note.CreateNoteDto;
import com.reminde.reminde_api.application.exceptions.ResourceNotFoundException;
import com.reminde.reminde_api.application.gateways.NoteGateway;
import com.reminde.reminde_api.application.mappers.NoteMapper;
import com.reminde.reminde_api.application.validators.NoteValidator;
import com.reminde.reminde_api.domain.models.Note;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import com.reminde.reminde_api.persistence.repositories.NoteEntityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class NoteService implements NoteGateway {
    private final NoteEntityRepository noteEntityRepository;
    private final NoteMapper noteMapper;
    private final NoteValidator noteValidator;

    public NoteService(NoteEntityRepository noteEntityRepository, 
                      NoteMapper noteMapper,
                      NoteValidator noteValidator) {
        this.noteEntityRepository = noteEntityRepository;
        this.noteMapper = noteMapper;
        this.noteValidator = noteValidator;
    }

    @Override
    public List<Note> getNotes() {
        return noteEntityRepository.findAll()
                .stream()
                .map(noteMapper::toModel)
                .toList();
    }

    public Note createNote(CreateNoteDto createNoteDto) {
        noteValidator.validateCreateNote(createNoteDto);
        
        Note note = noteMapper.toModel(createNoteDto);
        NoteEntity noteEntity = noteMapper.toEntity(note);
        noteEntity.setId(null);
        return noteMapper.toModel(noteEntityRepository.save(noteEntity));
    }

    @Override
    public Note updateNote(NoteDto note) {
        noteValidator.validateNote(note);
        Note noteModel = noteMapper.toModel(note);
        NoteEntity noteEntity = noteMapper.toEntity(noteModel);
        noteEntityRepository.findById(noteEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException(Note.class, note.getId()));
        return noteMapper.toModel(noteEntityRepository.save(noteEntity));
    }

    @Override
    public Note getNoteById(UUID id) throws ResourceNotFoundException {
        return noteMapper.toModel(noteEntityRepository.findById(id)
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
                .map(noteMapper::toModel)
                .toList();
    }
}
