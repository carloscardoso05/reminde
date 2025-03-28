package com.reminde.reminde_api.domain.models;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class User {
    private final UUID id;
    private final String name;
    private final String email;
    private final List<UUID> notesIds = new ArrayList<>();

    @Builder
    public User(UUID id, String name, String email, List<UUID> notesIds) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.notesIds.addAll(notesIds);
    }
}
