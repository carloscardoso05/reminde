package com.reminde.reminde_api.facades.mappers;

import com.reminde.reminde_api.application.mappers.UserDtoConverter;
import com.reminde.reminde_api.application.dtos.UserDto;
import com.reminde.reminde_api.domain.models.User;
import com.reminde.reminde_api.persistence.entities.UserEntity;
import com.reminde.reminde_api.persistence.mappers.UserJPAMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends MapperFacade<UserDto, User, UserEntity> {
    private final UserJPAMapper userJPAMapper;
    private final UserDtoConverter userDtoConverter;

    public UserMapper(UserJPAMapper userJPAMapper, UserDtoConverter userDtoConverter) {
        this.userJPAMapper = userJPAMapper;
        this.userDtoConverter = userDtoConverter;
    }


    @Override
    public UserDto dtoFromModel(User user) {
        return userDtoConverter.toDto(user);
    }

    @Override
    public User modelFromDto(UserDto userDto) {
        return userDtoConverter.toModel(userDto);
    }

    @Override
    public User modelFromEntity(UserEntity userEntity) {
        return userJPAMapper.toModel(userEntity);
    }

    @Override
    public UserEntity entityFromModel(User user) {
        return userJPAMapper.toEntity(user);
    }
}
