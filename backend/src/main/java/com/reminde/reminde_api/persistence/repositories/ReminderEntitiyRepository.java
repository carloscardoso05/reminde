package com.reminde.reminde_api.persistence.repositories;

import com.reminde.reminde_api.persistence.entities.ReminderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReminderEntitiyRepository extends JpaRepository<ReminderEntity, UUID> {
    List<ReminderEntity> findAllByNoteId(UUID noteId);
}
