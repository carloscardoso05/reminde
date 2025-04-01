package com.reminde.reminde_api.application.service;

import com.reminde.reminde_api.application.dto.CreateNoteRequest;
import com.reminde.reminde_api.application.dto.NoteDto;
import com.reminde.reminde_api.application.port.in.NoteUseCase;
import com.reminde.reminde_api.application.port.out.NoteRepository;
import com.reminde.reminde_api.domain.model.Note;
import com.reminde.reminde_api.persistence.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class NoteService implements NoteUseCase {
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @Override
    public NoteDto createNote(CreateNoteRequest request) {
        Note note = new Note(
            UUID.randomUUID(),
            request.title(),
            request.content(),
            request.dueDate(),
            request.tags(),
            request.reminders()
        );
        Note savedNote = noteRepository.save(note);
        return noteMapper.toDto(savedNote);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NoteDto> getNote(UUID id) {
        return noteRepository.findById(id)
                .map(noteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoteDto> getNotesByUser(UUID userId) {
        return noteRepository.findByUserId(userId)
                .stream()
                .map(noteMapper::toDto)
                .toList();
    }

    @Override
    public void deleteNote(UUID id) {
        if (noteRepository.findById(id).isPresent()) {
            noteRepository.deleteById(id);
        }
    }
} 