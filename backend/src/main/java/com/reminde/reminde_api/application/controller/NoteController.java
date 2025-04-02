package com.reminde.reminde_api.application.controller;

import com.reminde.reminde_api.application.dto.CreateNoteRequest;
import com.reminde.reminde_api.application.dto.NoteDto;
import com.reminde.reminde_api.application.port.in.NoteGateway;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteGateway noteGateway;

    @PostMapping
    public ResponseEntity<NoteDto> createNote(@Valid @RequestBody CreateNoteRequest request) {
        return ResponseEntity.ok(noteGateway.createNote(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDto> getNote(@PathVariable UUID id) {
        return noteGateway.getNote(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NoteDto>> getNotesByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(noteGateway.getNotesByOwner(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable UUID id) {
        noteGateway.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
} 