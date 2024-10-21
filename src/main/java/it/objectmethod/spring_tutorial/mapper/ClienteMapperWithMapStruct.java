package it.objectmethod.spring_tutorial.mapper;

import it.objectmethod.spring_tutorial.dto.ClienteDto;
import it.objectmethod.spring_tutorial.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapperWithMapStruct extends BaseMappingMethod<ClienteDto, Cliente> {
    @Override
    ClienteDto toDto(Cliente cliente);

    @Override
    List<ClienteDto> toDtoList(List<Cliente> clientes);

    @Override
    Cliente toEntity(ClienteDto clienteDto);

    @Mapping(target = "clienteId", source = "id")
    Cliente toEntity(ClienteDto clienteDto, Integer id);

    @Override
    List<Cliente> toEntityList(List<ClienteDto> clienteDtos);
}
