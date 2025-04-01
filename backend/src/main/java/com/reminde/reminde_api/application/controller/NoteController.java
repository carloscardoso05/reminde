package com.reminde.reminde_api.application.controller;

import com.reminde.reminde_api.application.dto.CreateNoteRequest;
import com.reminde.reminde_api.application.dto.NoteDto;
import com.reminde.reminde_api.application.port.in.NoteUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteUseCase noteUseCase;

    @PostMapping
    public ResponseEntity<NoteDto> createNote(@Valid @RequestBody CreateNoteRequest request) {
        return ResponseEntity.ok(noteUseCase.createNote(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDto> getNote(@PathVariable UUID id) {
        return noteUseCase.getNote(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NoteDto>> getNotesByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(noteUseCase.getNotesByUser(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable UUID id) {
        noteUseCase.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
} 