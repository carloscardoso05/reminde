package com.reminde.reminde_api.application.port.in;

import com.reminde.reminde_api.application.dto.CreateUserRequest;
import com.reminde.reminde_api.application.dto.UserDto;
import java.util.Optional;
import java.util.UUID;

public interface UserGateway {
    UserDto createUser(CreateUserRequest request);
    Optional<UserDto> getUser(UUID id);
    void deleteUser(UUID id);
} 