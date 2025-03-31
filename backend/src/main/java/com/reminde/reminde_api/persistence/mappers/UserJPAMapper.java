package com.reminde.reminde_api.persistence.mappers;

import com.reminde.reminde_api.domain.models.User;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import com.reminde.reminde_api.persistence.entities.UserEntity;
import com.reminde.reminde_api.persistence.repositories.NoteEntityRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class UserJPAMapper {

    @Autowired
    protected NoteEntityRepository noteEntityRepository;

    @Mapping(target = "notes", ignore = true)
    public abstract UserEntity toEntity(User user);

    @Mapping(target = "notesIds", source = "notes", qualifiedByName = "mapNotesToIds")
    public abstract User toModel(UserEntity userEntity);

    @AfterMapping
    protected void populateNotes(User user, @MappingTarget UserEntity entity) {
        if (user.getId() != null) {
            List<NoteEntity> notes = noteEntityRepository.findAllByOwnerId(user.getId());
            entity.setNotes(notes);
        }
    }

    @Named("mapNotesToIds")
    protected List<UUID> mapNotesToIds(List<NoteEntity> notes) {
        return notes.stream()
                .map(NoteEntity::getId)
                .toList();
    }
}