package com.reminde.reminde_api.application.port.out;

import com.reminde.reminde_api.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    void deleteById(UUID id);
} 