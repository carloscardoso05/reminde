package com.reminde.reminde_api.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reminde.reminde_api.application.dto.CreateUserRequest;
import com.reminde.reminde_api.application.dto.UserDto;
import com.reminde.reminde_api.application.mappers.DtoUserMapper;
import com.reminde.reminde_api.application.port.in.UserGateway;
import com.reminde.reminde_api.application.port.out.UserRepository;
import com.reminde.reminde_api.domain.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserGateway {
    private final UserRepository userRepository;
    private final DtoUserMapper mapper;

    @Override
    public UserDto createUser(CreateUserRequest request) {
        User user = new User(UUID.randomUUID(), request.name(), request.email(), List.of());
        User savedUser = userRepository.save(user);
        return mapper.toDto(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> getUser(UUID id) {
        return userRepository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public void deleteUser(UUID id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }
} 