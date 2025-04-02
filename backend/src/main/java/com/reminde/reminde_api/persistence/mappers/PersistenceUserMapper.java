package com.reminde.reminde_api.persistence.mappers;

import com.reminde.reminde_api.domain.model.User;
import com.reminde.reminde_api.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring")
public interface PersistenceUserMapper {
    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);
}