package com.reminde.reminde_api.facades.mappers;

import com.reminde.reminde_api.application.mappers.NoteDtoMapper;
import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.domain.models.Note;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import com.reminde.reminde_api.persistence.mappers.NoteJPAMapper;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper extends MapperFacade<NoteDto, Note, NoteEntity> {
    private final NoteJPAMapper noteJPAMapper;
    private final NoteDtoMapper noteDtoMapper;

    public NoteMapper(NoteJPAMapper noteJPAMapper, NoteDtoMapper noteDtoMapper) {
        this.noteJPAMapper = noteJPAMapper;
        this.noteDtoMapper = noteDtoMapper;
    }

    @Override
    public NoteDto dtoFromModel(Note note) {
        return noteDtoMapper.toDto(note);
    }

    @Override
    public Note modelFromDto(NoteDto noteDto) {
        return noteDtoMapper.toModel(noteDto);
    }

    @Override
    public Note modelFromEntity(NoteEntity noteEntity) {
        return noteJPAMapper.toModel(noteEntity);
    }

    @Override
    public NoteEntity entityFromModel(Note note) {
        return noteJPAMapper.toEntity(note);
    }
}
