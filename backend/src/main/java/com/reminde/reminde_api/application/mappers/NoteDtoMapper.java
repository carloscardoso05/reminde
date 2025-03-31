package com.reminde.reminde_api.application.mappers;

import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.domain.models.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class NoteDtoMapper {
    public abstract NoteDto toDto(Note note);

    public abstract Note toModel(NoteDto noteDto);
}
