package it.objectmethod.spring_tutorial.mapper;

import it.objectmethod.spring_tutorial.dto.DipendenteDto;
import it.objectmethod.spring_tutorial.entity.Dipendente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DipendenteMapperWithMapStruct extends BaseMappingMethod<DipendenteDto, Dipendente> {
    @Override
    DipendenteDto toDto(Dipendente dipendente);

    @Override
    List<DipendenteDto> toDtoList(List<Dipendente> dipendentes);

    @Override
    Dipendente toEntity(DipendenteDto dipendenteDto);

    @Override
    List<Dipendente> toEntityList(List<DipendenteDto> dipendenteDtos);
}
