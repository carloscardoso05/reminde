package com.reminde.reminde_api.application.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Class<?> clazz, UUID id) {
        super(clazz.getSimpleName() + " not found with id: " + id);
    }
}
