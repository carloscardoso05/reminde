package com.reminde.reminde_api.application.controllers;

import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.application.dtos.note.CreateNoteDto;
import com.reminde.reminde_api.application.mappers.NoteMapper;
import com.reminde.reminde_api.application.services.NoteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;
    private final NoteMapper noteMapper;

    public NoteController(NoteService noteService, NoteMapper noteMapper) {
        this.noteService = noteService;
        this.noteMapper = noteMapper;
    }

    @GetMapping
    public List<NoteDto> getNotes() {
        return noteService.getNotes().stream()
                .map(noteMapper::toDto)
                .toList();
    }

    @PostMapping
    public NoteDto createNote(@Valid @RequestBody CreateNoteDto createNoteDto) {
        return noteMapper.toDto(noteService.createNote(createNoteDto));
    }
}
