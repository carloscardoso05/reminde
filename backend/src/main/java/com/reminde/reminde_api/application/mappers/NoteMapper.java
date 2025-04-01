package com.reminde.reminde_api.application.mappers;

import com.reminde.reminde_api.application.dtos.NoteDto;
import com.reminde.reminde_api.application.dtos.note.CreateNoteDto;
import com.reminde.reminde_api.domain.models.Note;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import com.reminde.reminde_api.persistence.entities.ReminderEntity;
import com.reminde.reminde_api.persistence.entities.TagEntity;
import com.reminde.reminde_api.persistence.entities.UserEntity;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class NoteMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "reminders", ignore = true)
    public abstract Note toModel(CreateNoteDto createNoteDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "reminders", ignore = true)
    public abstract Note toModel(NoteDto noteDto);

    @Mapping(target = "tags", source = "tags", qualifiedByName = "mapTagsToTagEntities")
    @Mapping(target = "reminders", source = "reminders", qualifiedByName = "mapRemindersToReminderEntities")
    @Mapping(target = "owner", source = "ownerId", qualifiedByName = "mapOwnerIdToUserEntity")
    public abstract NoteEntity toEntity(Note note);

    @Mapping(target = "tags", source = "tags", qualifiedByName = "mapTagEntitiesToTags")
    @Mapping(target = "reminders", source = "reminders", qualifiedByName = "mapReminderEntitiesToReminders")
    @Mapping(target = "ownerId", source = "owner.id")
    public abstract Note toModel(NoteEntity noteEntity);

    @Mapping(target = "ownerId", source = "ownerId")
    public abstract NoteDto toDto(Note note);

    @Named("mapTagsToTagEntities")
    protected List<TagEntity> mapTagsToTagEntities(List<String> tags) {
        if (tags == null) return null;
        return tags.stream()
                .map(tag -> {
                    TagEntity entity = new TagEntity();
                    entity.setName(tag);
                    return entity;
                })
                .collect(Collectors.toList());
    }

    @Named("mapRemindersToReminderEntities")
    protected List<ReminderEntity> mapRemindersToReminderEntities(List<LocalDateTime> reminders) {
        if (reminders == null) return null;
        return reminders.stream()
                .map(reminder -> {
                    ReminderEntity entity = new ReminderEntity();
                    entity.setDateTime(reminder);
                    return entity;
                })
                .collect(Collectors.toList());
    }

    @Named("mapTagEntitiesToTags")
    protected List<String> mapTagEntitiesToTags(List<TagEntity> tags) {
        if (tags == null) return null;
        return tags.stream()
                .map(TagEntity::getName)
                .collect(Collectors.toList());
    }

    @Named("mapReminderEntitiesToReminders")
    protected List<LocalDateTime> mapReminderEntitiesToReminders(List<ReminderEntity> reminders) {
        if (reminders == null) return null;
        return reminders.stream()
                .map(ReminderEntity::getDateTime)
                .collect(Collectors.toList());
    }

    @Named("mapOwnerIdToUserEntity")
    protected UserEntity mapOwnerIdToUserEntity(UUID ownerId) {
        if (ownerId == null) return null;
        UserEntity user = new UserEntity();
        user.setId(ownerId);
        return user;
    }
} 