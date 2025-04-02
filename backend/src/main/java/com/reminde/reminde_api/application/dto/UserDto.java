package com.reminde.reminde_api.application.dto;

import java.util.List;
import java.util.UUID;

public record UserDto(
    UUID id,
    String name,
    String email,
    List<UUID> notesIds
) {} 