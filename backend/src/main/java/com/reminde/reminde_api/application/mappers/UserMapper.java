package com.reminde.reminde_api.application.mappers;

import com.reminde.reminde_api.application.dtos.UserDto;
import com.reminde.reminde_api.domain.models.User;
import com.reminde.reminde_api.persistence.entities.UserEntity;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "notesIds", source = "notesIds")
    public abstract User toModel(UserDto userDto);

    @Mapping(target = "notes", source = "notesIds", qualifiedByName = "mapNotesIdsToNoteEntities")
    public abstract UserEntity toEntity(User user);

    @Mapping(target = "notesIds", source = "notes", qualifiedByName = "mapNoteEntitiesToNotesIds")
    public abstract User toModel(UserEntity userEntity);

    @Mapping(target = "notesIds", source = "notesIds")
    public abstract UserDto toDto(User user);

    @Named("mapNotesIdsToNoteEntities")
    protected List<NoteEntity> mapNotesIdsToNoteEntities(List<UUID> notesIds) {
        if (notesIds == null) return null;
        return notesIds.stream()
                .map(id -> {
                    NoteEntity note = new NoteEntity();
                    note.setId(id);
                    return note;
                })
                .collect(Collectors.toList());
    }

    @Named("mapNoteEntitiesToNotesIds")
    protected List<UUID> mapNoteEntitiesToNotesIds(List<NoteEntity> notes) {
        if (notes == null) return null;
        return notes.stream()
                .map(NoteEntity::getId)
                .collect(Collectors.toList());
    }
} 