package com.reminde.reminde_api.application.usecases;

import com.reminde.reminde_api.application.dtos.UserDto;
import com.reminde.reminde_api.domain.models.User;

import java.util.UUID;

public interface UserUseCases {
    User createUser(UserDto userDto);
    User updateUser(UserDto userDto);
    User getUserById(UUID id);
    User getUserByEmail(String email);
}
