package com.reminde.reminde_api.persistence.adapters;

import com.reminde.reminde_api.application.port.out.UserRepository;
import com.reminde.reminde_api.domain.model.User;
import com.reminde.reminde_api.persistence.entities.UserEntity;
import com.reminde.reminde_api.persistence.mappers.PersistenceUserMapper;
import com.reminde.reminde_api.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepository {
    private final JpaUserRepository userRepository;
    private final PersistenceUserMapper mapper;

    @Override
    public User save(User user) {
        final UserEntity entity = mapper.toEntity(user);
        final UserEntity savedEntity = userRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
} 