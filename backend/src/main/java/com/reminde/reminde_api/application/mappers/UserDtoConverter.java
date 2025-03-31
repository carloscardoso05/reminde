package com.reminde.reminde_api.application.mappers;

import com.reminde.reminde_api.application.dtos.UserDto;
import com.reminde.reminde_api.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserDtoConverter {

    public abstract User toModel(UserDto userDto);

    public abstract UserDto toDto(User user);
}
