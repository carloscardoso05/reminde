package com.reminde.reminde_api.application.dto;

import java.util.UUID;

public record UserDto(
    UUID id,
    String name
) {} 