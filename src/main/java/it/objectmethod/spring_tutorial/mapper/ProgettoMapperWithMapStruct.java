package it.objectmethod.spring_tutorial.mapper;

import it.objectmethod.spring_tutorial.dto.ProgettoDto;
import it.objectmethod.spring_tutorial.entity.Progetto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProgettoMapperWithMapStruct extends BaseMappingMethod<ProgettoDto, Progetto> {
    @Override
    ProgettoDto toDto(Progetto progetto);

    @Override
    List<ProgettoDto> toDtoList(List<Progetto> progettos);

    @Override
    Progetto toEntity(ProgettoDto progettoDto);

    @Override
    List<Progetto> toEntityList(List<ProgettoDto> progettoDtos);
}
