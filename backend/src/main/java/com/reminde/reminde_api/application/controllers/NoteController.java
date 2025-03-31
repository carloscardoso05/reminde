package com.reminde.reminde_api.application.controllers;

import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.application.services.NoteService;
import com.reminde.reminde_api.facades.mappers.NoteMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;
    private final NoteMapper noteConverter;

    public NoteController(NoteService noteService, NoteMapper noteConverter) {
        this.noteService = noteService;
        this.noteConverter = noteConverter;
    }

    @GetMapping
    public List<NoteDto> getNotes() {
        return noteService.getNotes().stream()
                .map(noteConverter::dtoFromModel)
                .toList();
    }

    @PostMapping
    public NoteDto createNote(@RequestBody NoteDto note) {
        return noteConverter.dtoFromModel(noteService.createNote(note));
    }
}
