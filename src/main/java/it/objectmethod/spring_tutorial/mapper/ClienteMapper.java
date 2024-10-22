//package it.objectmethod.spring_tutorial.mapper;
//
//import it.objectmethod.spring_tutorial.dto.ClienteDto;
//import it.objectmethod.spring_tutorial.entity.Cliente;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class ClienteMapper implements BaseMappingMethod<ClienteDto, Cliente> {
//    @Override
//    public ClienteDto toDto(Cliente cliente) {
//        ClienteDto dto = new ClienteDto();
//        dto.setNome(cliente.getNome());
//        dto.setCognome(cliente.getCognome());
//        dto.setAzienda(cliente.getAzienda());
//        return dto;
//    }
//
//    @Override
//    public List<ClienteDto> toDtoList(List<Cliente> clientes) {
//        List<ClienteDto>dtoList=new ArrayList<>();
//        for(Cliente cliente : clientes){
//            dtoList.add(toDto(cliente));
//        }
//        return dtoList;
//    }
//
//    @Override
//    public Cliente toEntity(ClienteDto clienteDto) {
//        Cliente cliente = new Cliente();
//        cliente.setNome(clienteDto.getNome());
//        cliente.setCognome(clienteDto.getCognome());
//        cliente.setAzienda(clienteDto.getAzienda());
//        return cliente;
//    }
//
//    @Override
//    public List<Cliente> toEntityList(List<ClienteDto> clienteDtos) {
//        List<Cliente> clientes = new ArrayList<>();
//        for(ClienteDto dto : clienteDtos){
//            clientes.add(toEntity(dto));
//        }
//        return clientes;
//    }
//}
