package it.objectmethod.spring_tutorial.mapper;

import java.util.List;

public interface BaseMappingMethod<DTO, ENTITY> {
    DTO toDto(ENTITY entity);

    List<DTO> toDtoList(List<ENTITY> entities);

    ENTITY toEntity(DTO dto);

    List<ENTITY> toEntityList(List<DTO> dtos);
}
