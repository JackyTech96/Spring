package it.objectmethod.spring_tutorial.mapper;

import it.objectmethod.spring_tutorial.dto.ProgettoDipendenteDto;
import it.objectmethod.spring_tutorial.entity.ProgettoDipendente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProgettoMapperWithMapStruct.class, DipendenteMapperWithMapStruct.class})
public interface ProgettoDipendenteMapperWithMapStruct extends BaseMappingMethod<ProgettoDipendenteDto, ProgettoDipendente> {
    @Mapping(source = "progetto.progettoId", target = "progettoId")
    @Mapping(source = "dipendente.dipendenteId", target = "dipendenteId")
    @Mapping(source="progetto", target="progettoDto")
    @Mapping(source="dipendente", target="dipendenteDto")
    @Override
    ProgettoDipendenteDto toDto(ProgettoDipendente progettoDipendente);

    @Override
    List<ProgettoDipendenteDto> toDtoList(List<ProgettoDipendente> progettoDipendentes);

    @Mapping(source = "progettoId", target = "progetto.progettoId")
    @Mapping(source = "dipendenteId", target = "dipendente.dipendenteId")
    @Mapping(source="progettoDto", target="progetto")
    @Mapping(source="dipendenteDto", target="dipendente")
    @Override
    ProgettoDipendente toEntity(ProgettoDipendenteDto progettoDipendenteDto);

    @Override
    List<ProgettoDipendente> toEntityList(List<ProgettoDipendenteDto> progettoDipendenteDtos);
}
