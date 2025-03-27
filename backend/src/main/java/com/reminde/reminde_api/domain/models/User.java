package com.reminde.reminde_api.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Getter
public class User {
    private final UUID id;
    private final String name;
    private final String email;
    private final List<Note> notes = new ArrayList<>();

    @Builder
    public User(UUID id, String name, String email, @Singular List<Note> notes) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.notes.addAll(notes);
        this.notes.sort(Comparator.comparing(Note::getCreatedAt));
    }
}
