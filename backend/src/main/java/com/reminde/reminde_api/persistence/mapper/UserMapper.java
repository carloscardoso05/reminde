package com.reminde.reminde_api.persistence.mapper;

import com.reminde.reminde_api.application.dto.UserDto;
import com.reminde.reminde_api.domain.model.User;
import com.reminde.reminde_api.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomain(UserEntity entity);
    UserEntity toEntity(User domain);
    UserDto toDto(User domain);
} 