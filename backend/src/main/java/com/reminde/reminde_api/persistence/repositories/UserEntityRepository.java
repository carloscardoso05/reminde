package com.reminde.reminde_api.persistence.repositories;

import com.reminde.reminde_api.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
}
