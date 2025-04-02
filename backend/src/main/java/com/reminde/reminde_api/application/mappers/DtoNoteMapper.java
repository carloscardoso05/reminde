package com.reminde.reminde_api.application.mappers;

import com.reminde.reminde_api.application.dto.NoteDto;
import com.reminde.reminde_api.domain.model.Note;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring")
public interface DtoNoteMapper {
    NoteDto toDto(Note note);

    Note toDomain(NoteDto dto);
}
