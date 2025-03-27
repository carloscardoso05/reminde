package com.reminde.reminde_api.domain.models;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Tag {
    private final UUID uuid;
    private final String name;
}
