package com.reminde.reminde_api.persistence.mappers;

import com.reminde.reminde_api.domain.models.Note;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import com.reminde.reminde_api.persistence.entities.ReminderEntity;
import com.reminde.reminde_api.persistence.entities.TagEntity;
import com.reminde.reminde_api.persistence.entities.UserEntity;
import com.reminde.reminde_api.persistence.repositories.ReminderEntitiyRepository;
import com.reminde.reminde_api.persistence.repositories.TagEntityRepository;
import com.reminde.reminde_api.persistence.repositories.UserEntityRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class NoteJPAMapper {
    @Autowired
    protected TagEntityRepository tagEntityRepository;
    @Autowired
    protected UserEntityRepository userEntityRepository;
    @Autowired
    protected ReminderEntitiyRepository reminderEntitiyRepository;

    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "reminders", ignore = true)
    @Mapping(target = "owner", source = "ownerId", qualifiedByName = "mapOwnerIdToUserEntity")
    public abstract NoteEntity toEntity(Note note);

    @Mapping(target = "tags", source = "tags", qualifiedByName = "mapTagsToTagsNames")
    @Mapping(target = "reminders", qualifiedByName = "mapRemindersToLocalDateTime")
    @Mapping(target = "ownerId", source = "owner.id")
    public abstract Note toModel(NoteEntity noteEntity);

    @Named("mapOwnerIdToUserEntity")
    protected UserEntity mapOwnerIdToUserEntity(UUID ownerId) {
        if (ownerId == null)
            return null;
        return userEntityRepository.findById(ownerId).orElse(null);
    }

    @Named("mapRemindersToLocalDateTime")
    protected List<LocalDateTime> mapRemindersToLocalDateTime(List<ReminderEntity> reminders) {
        return reminders.stream()
                .map(ReminderEntity::getDateTime)
                .toList();
    }

    @AfterMapping
    protected void populateReminders(Note note, @MappingTarget NoteEntity entity) {
        if (note.getId() != null) {
            List<ReminderEntity> reminders = reminderEntitiyRepository.findAllByNoteId(note.getId());
            entity.setReminders(reminders);
        }
    }

    @AfterMapping
    protected void populateTags(Note note, @MappingTarget NoteEntity entity) {
        if (note.getId() != null) {
            List<TagEntity> tags = tagEntityRepository.findAllByNoteId(note.getId());
            entity.setTags(tags);
        }
    }


    @Named("mapTagsToTagsNames")
    protected List<String> mapTagsToTagsNames(List<TagEntity> tags) {
        return tags.stream()
                .map(TagEntity::getName)
                .toList();
    }
}
