package com.reminde.reminde_api.persistence.repositories;

import com.reminde.reminde_api.persistence.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TagEntityRepository extends JpaRepository<TagEntity, UUID> {
    @Query("""
            select tag from TagEntity tag join tag.notes note where note.id = :note_id
            """)
    List<TagEntity> findAllByNoteId(@Param("note_id") UUID noteId);
}
