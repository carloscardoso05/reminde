package com.reminde.reminde_api.application.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class TagDto {
    private UUID uuid;
    private String name;
}
