package com.reminde.reminde_api.persistence.mapper;

import com.reminde.reminde_api.application.dto.NoteDto;
import com.reminde.reminde_api.domain.model.Note;
import com.reminde.reminde_api.persistence.entity.NoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    Note toDomain(NoteEntity entity);
    NoteEntity toEntity(Note domain);
    NoteDto toDto(Note domain);
} 