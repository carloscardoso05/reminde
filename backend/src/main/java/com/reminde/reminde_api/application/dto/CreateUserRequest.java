package com.reminde.reminde_api.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
    @NotBlank(message = "Name is required")
    String name
) {} 