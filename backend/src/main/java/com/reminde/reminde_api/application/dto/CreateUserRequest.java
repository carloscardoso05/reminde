package com.reminde.reminde_api.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
    @NotBlank(message = "Name is required")
    String name,
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email
) {} 