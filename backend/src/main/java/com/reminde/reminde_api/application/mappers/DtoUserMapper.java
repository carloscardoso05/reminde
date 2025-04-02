package com.reminde.reminde_api.application.mappers;

import com.reminde.reminde_api.application.dto.UserDto;
import com.reminde.reminde_api.domain.model.User;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring")
public interface DtoUserMapper {
    UserDto toDto(User user);

    User toDomain(UserDto dto);
}
