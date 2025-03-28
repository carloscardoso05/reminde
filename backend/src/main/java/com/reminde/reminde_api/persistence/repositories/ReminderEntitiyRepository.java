package com.reminde.reminde_api.persistence.repositories;

import com.reminde.reminde_api.persistence.entities.ReminderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReminderEntitiyRepository extends JpaRepository<ReminderEntity, UUID> {
}
