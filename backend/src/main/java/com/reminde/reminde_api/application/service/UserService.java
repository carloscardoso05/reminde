package com.reminde.reminde_api.application.service;

import com.reminde.reminde_api.application.dto.CreateUserRequest;
import com.reminde.reminde_api.application.dto.UserDto;
import com.reminde.reminde_api.application.port.in.UserUseCase;
import com.reminde.reminde_api.application.port.out.UserRepository;
import com.reminde.reminde_api.domain.model.User;
import com.reminde.reminde_api.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserUseCase {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(CreateUserRequest request) {
        User user = new User(UUID.randomUUID(), request.name());
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> getUser(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::toDto);
    }

    @Override
    public void deleteUser(UUID id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }
} 