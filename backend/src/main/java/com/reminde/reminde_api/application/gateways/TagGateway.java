package com.reminde.reminde_api.application.gateways;

import com.reminde.reminde_api.application.dtos.TagDto;

import java.util.List;
import java.util.UUID;

public interface TagGateway {
    Tag createTag(TagDto tag);

    Tag updateTag(TagDto tag);

    void deleteTagById(UUID id);

    Tag getTagById(UUID id);

    List<Tag> getTagsByNoteId(UUID noteId);
}
