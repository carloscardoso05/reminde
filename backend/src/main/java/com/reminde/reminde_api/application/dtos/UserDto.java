package com.reminde.reminde_api.application.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String name;
    private String email;
    private final List<UUID> notesIds = new ArrayList<>();

    @Builder
    public UserDto(UUID id, String name, String email, List<UUID> notesIds) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.notesIds.addAll(notesIds);
    }
}
