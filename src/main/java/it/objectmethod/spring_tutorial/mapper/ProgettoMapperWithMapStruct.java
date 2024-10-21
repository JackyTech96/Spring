package it.objectmethod.spring_tutorial.mapper;

import it.objectmethod.spring_tutorial.dto.ProgettoDto;
import it.objectmethod.spring_tutorial.entity.Progetto;

import java.util.List;

public interface ProgettoMapperWithMapStruct extends BaseMappingMethod <ProgettoDto, Progetto>{
    @Override
    ProgettoDto toDto(Progetto progetto);

    @Override
    List<ProgettoDto> toDtoList(List<Progetto> progettos);

    @Override
    Progetto toEntity(ProgettoDto progettoDto);

    @Override
    List<Progetto> toEntityList(List<ProgettoDto> progettoDtos);
}
