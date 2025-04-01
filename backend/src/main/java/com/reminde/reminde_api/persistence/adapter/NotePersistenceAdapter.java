package com.reminde.reminde_api.persistence.adapter;

import com.reminde.reminde_api.application.port.out.NoteRepository;
import com.reminde.reminde_api.domain.model.Note;
import com.reminde.reminde_api.persistence.entity.NoteEntity;
import com.reminde.reminde_api.persistence.mapper.NoteMapper;
import com.reminde.reminde_api.persistence.repository.JpaNoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class NotePersistenceAdapter implements NoteRepository {
    private final JpaNoteRepository jpaNoteRepository;
    private final NoteMapper noteMapper;

    @Override
    public Note save(Note note) {
        NoteEntity entity = noteMapper.toEntity(note);
        NoteEntity savedEntity = jpaNoteRepository.save(entity);
        return noteMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Note> findById(UUID id) {
        return jpaNoteRepository.findById(id)
                .map(noteMapper::toDomain);
    }

    @Override
    public List<Note> findByUserId(UUID userId) {
        return jpaNoteRepository.findByUserId(userId)
                .stream()
                .map(noteMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaNoteRepository.deleteById(id);
    }
} 