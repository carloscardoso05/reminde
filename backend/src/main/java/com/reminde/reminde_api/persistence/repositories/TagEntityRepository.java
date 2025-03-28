package com.reminde.reminde_api.persistence.repositories;

import com.reminde.reminde_api.persistence.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagEntityRepository extends JpaRepository<TagEntity, UUID> {
}
