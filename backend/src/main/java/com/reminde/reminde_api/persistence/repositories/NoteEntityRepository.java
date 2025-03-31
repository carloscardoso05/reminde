package com.reminde.reminde_api.persistence.repositories;

import com.reminde.reminde_api.persistence.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NoteEntityRepository extends JpaRepository<NoteEntity, UUID> {
    List<NoteEntity> findAllByOwnerId(UUID ownerId);
}
