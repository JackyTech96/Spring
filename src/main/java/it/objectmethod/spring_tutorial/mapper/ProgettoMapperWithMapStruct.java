package it.objectmethod.spring_tutorial.mapper;

import it.objectmethod.spring_tutorial.dto.ProgettoDto;
import it.objectmethod.spring_tutorial.entity.Progetto;
import it.objectmethod.spring_tutorial.entity.ProgettoDipendente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.stream.Collectors;

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

    @Mapping(target = "nome", source = "progetto.nome")
    @Mapping(target = "descrizione", source = "progetto.descrizione")
    ProgettoDto toDto(ProgettoDipendente progettoDipendente);

    default List<ProgettoDto> toDtoListFromProgettoDipendente(List<ProgettoDipendente> progettoDipendenti) {
        return progettoDipendenti.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
