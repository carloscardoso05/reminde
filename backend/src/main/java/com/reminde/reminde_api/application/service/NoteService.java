package com.reminde.reminde_api.application.service;

import com.reminde.reminde_api.application.dto.CreateNoteRequest;
import com.reminde.reminde_api.application.dto.NoteDto;
import com.reminde.reminde_api.application.mappers.DtoNoteMapper;
import com.reminde.reminde_api.application.port.in.NoteGateway;
import com.reminde.reminde_api.application.port.out.NoteRepository;
import com.reminde.reminde_api.domain.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class NoteService implements NoteGateway {
    private final NoteRepository noteRepository;
    private final DtoNoteMapper mapper;

    @Override
    public NoteDto createNote(CreateNoteRequest request) {
        Note note = new Note(
            UUID.randomUUID(),
            request.ownerId(),
            request.title(),
            request.content(),
            request.dueDate(),
            request.tags(),
            request.reminders()
        );
        Note savedNote = noteRepository.save(note);
        return mapper.toDto(savedNote);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NoteDto> getNote(UUID id) {
        return noteRepository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoteDto> getNotesByOwner(UUID userId) {
        return noteRepository.findByOwnerId(userId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void deleteNote(UUID id) {
        if (noteRepository.findById(id).isPresent()) {
            noteRepository.deleteById(id);
        }
    }
} 