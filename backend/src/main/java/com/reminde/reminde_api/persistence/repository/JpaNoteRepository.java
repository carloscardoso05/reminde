package com.reminde.reminde_api.persistence.repository;

import com.reminde.reminde_api.persistence.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaNoteRepository extends JpaRepository<NoteEntity, UUID> {
    List<NoteEntity> findByOwnerId(UUID ownerId);
} 