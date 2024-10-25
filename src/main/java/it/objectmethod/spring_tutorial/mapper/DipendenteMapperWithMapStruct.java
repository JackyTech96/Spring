package it.objectmethod.spring_tutorial.mapper;

import it.objectmethod.spring_tutorial.dto.DipendenteDto;
import it.objectmethod.spring_tutorial.entity.Dipendente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProgettoMapperWithMapStruct.class})
public interface DipendenteMapperWithMapStruct extends BaseMappingMethod<DipendenteDto, Dipendente> {

    @Mapping(target = "progettiDipendentiListDto", source = "progettiDipendentiList")
    DipendenteDto toDto(Dipendente dipendente);

    @Override
    List<DipendenteDto> toDtoList(List<Dipendente> dipendentes);

    @Override
    Dipendente toEntity(DipendenteDto dipendenteDto);

    @Override
    List<Dipendente> toEntityList(List<DipendenteDto> dipendenteDtos);
}

