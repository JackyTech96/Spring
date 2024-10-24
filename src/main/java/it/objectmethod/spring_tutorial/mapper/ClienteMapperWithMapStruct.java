package it.objectmethod.spring_tutorial.mapper;

import it.objectmethod.spring_tutorial.dto.ClienteDto;
import it.objectmethod.spring_tutorial.dto.ProgettoDto;
import it.objectmethod.spring_tutorial.entity.Cliente;
import it.objectmethod.spring_tutorial.entity.Progetto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ProgettoMapperWithMapStruct.class})
public interface ClienteMapperWithMapStruct extends BaseMappingMethod<ClienteDto, Cliente> {
    @Override
    ClienteDto toDto(Cliente cliente);

    @Override
    List<ClienteDto> toDtoList(List<Cliente> clientes);

    @Override
    Cliente toEntity(ClienteDto clienteDto);

    @Override
    List<Cliente> toEntityList(List<ClienteDto> clienteDtos);

/** RISOLTO CON L'UTILIZZO DI uses = {ProgettoMapperWithMapStruct.class} :)
*    ProgettoDto toProgettoDto(Progetto progetto);
*
*    List<ProgettoDto> toProgettoDtoList(List<Progetto> progettos);
*
*    List<Progetto> toProgettoEntityList(List<ProgettoDto> progettoDtos);
*/

}
