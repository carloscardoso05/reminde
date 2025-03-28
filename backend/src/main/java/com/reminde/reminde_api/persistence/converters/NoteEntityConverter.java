package com.reminde.reminde_api.persistence.converters;

import com.reminde.reminde_api.domain.models.Note;
import com.reminde.reminde_api.persistence.entities.NoteEntity;
import com.reminde.reminde_api.persistence.entities.ReminderEntity;
import com.reminde.reminde_api.persistence.entities.TagEntity;
import com.reminde.reminde_api.persistence.repositories.TagEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteEntityConverter {
    private final TagEntityRepository tagEntityRepository;

    public NoteEntityConverter(TagEntityRepository tagEntityRepository) {
        this.tagEntityRepository = tagEntityRepository;
    }

    Note toDomainModel(NoteEntity noteEntity) {
        return Note.builder()
                .id(noteEntity.getId())
                .title(noteEntity.getTitle())
                .content(noteEntity.getContent())
                .createdAt(noteEntity.getCreatedAt())
                .updatedAt(noteEntity.getUpdatedAt())
                .dueDate(noteEntity.getDueDate())
                .tags(noteEntity.getTags().stream().map(TagEntity::getName).toList())
                .reminders(noteEntity.getReminders().stream().map(ReminderEntity::getDateTime).toList())
                .build();
    }
}
