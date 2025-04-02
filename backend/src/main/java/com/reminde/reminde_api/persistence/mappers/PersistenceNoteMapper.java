package com.reminde.reminde_api.persistence.mappers;

import com.reminde.reminde_api.domain.model.Note;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring")
public interface PersistenceNoteMapper {
    @Mapping(target = "ownerId", source = "entity.owner.id")
    Note toDomain(NoteEntity entity);
    NoteEntity toEntity(Note domain);
}