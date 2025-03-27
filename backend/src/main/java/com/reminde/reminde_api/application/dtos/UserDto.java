package com.reminde.reminde_api.application.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String name;
    private String email;
    private final List<Integer> notesIds = new ArrayList<>();
}
