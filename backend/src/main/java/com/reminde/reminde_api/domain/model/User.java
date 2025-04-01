package com.reminde.reminde_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class User {
    private final UUID id;
    private final String name;
} 