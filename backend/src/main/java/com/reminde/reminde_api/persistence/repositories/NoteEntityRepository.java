package com.reminde.reminde_api.persistence.repositories;

import com.reminde.reminde_api.persistence.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteEntityRepository extends JpaRepository<NoteEntity, UUID> {
}
