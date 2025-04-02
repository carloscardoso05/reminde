package com.reminde.reminde_api.persistence.adapters;

import com.reminde.reminde_api.application.port.out.NoteRepository;
import com.reminde.reminde_api.domain.model.Note;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import com.reminde.reminde_api.persistence.mappers.PersistenceNoteMapper;
import com.reminde.reminde_api.persistence.repository.JpaNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class NotePersistenceAdapter implements NoteRepository {
    private final JpaNoteRepository noteRepository;
    private final PersistenceNoteMapper mapper;

    @Override
    public Note save(Note note) {
        final NoteEntity entity = mapper.toEntity(note);
        final NoteEntity savedEntity = noteRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Note> findById(UUID id) {
        return noteRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Note> findByOwnerId(UUID ownerId) {
        return noteRepository.findByOwnerId(ownerId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        noteRepository.deleteById(id);
    }
} 