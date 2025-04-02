package com.reminde.reminde_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private final UUID id;
    private final String name;
    private final String email;
    private final List<UUID> notesIds;
} 