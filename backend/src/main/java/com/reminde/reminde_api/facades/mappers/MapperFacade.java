package com.reminde.reminde_api.facades.mappers;

public abstract class MapperFacade<Dto, Model, Entity> {
    public abstract Dto dtoFromModel(Model model);

    public Dto dtoFromEntity(Entity entity) {
        return dtoFromModel(modelFromEntity(entity));
    }

    public abstract Model modelFromDto(Dto dto);

    public abstract Model modelFromEntity(Entity entity);

    public abstract Entity entityFromModel(Model model);

    public Entity entityFromDto(Dto dto) {
        return entityFromModel(modelFromDto(dto));
    }
}
