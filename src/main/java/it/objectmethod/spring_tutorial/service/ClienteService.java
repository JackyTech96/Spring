package it.objectmethod.spring_tutorial.service;

import it.objectmethod.spring_tutorial.dto.ClienteDto;
import it.objectmethod.spring_tutorial.entity.Cliente;
import it.objectmethod.spring_tutorial.param.ClienteParams;
import it.objectmethod.spring_tutorial.mapper.ClienteMapperWithMapStruct;
import it.objectmethod.spring_tutorial.repository.ClienteRepository;
import it.objectmethod.spring_tutorial.response.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapperWithMapStruct clientewithMapStruct;

    public List<ClienteDto> getAllCLienti() {
        List<Cliente> clienti = clienteRepository.findAll();
        return clientewithMapStruct.toDtoList(clienti);
    }

    public ResponseWrapper<ClienteDto> findClienteById(final Integer clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();
        return new ResponseWrapper<>("Trovato", clientewithMapStruct.toDto(cliente));
    }

//    public List<ClienteDto> findByNome(final String nome) {
//      final List<Cliente> entities = clienteRepository.findByNome(nome);
//      final List<ClienteDto> toDtos = withMapStruct.toDtoList(entities);
//        return clientewithMapStruct.toDtoList(clienteRepository.findByNome(nome));
//    }


//    public List<ClienteDto> findByCognome(final String cognome) {
//        return clientewithMapStruct.toDtoList(clienteRepository.findByCognome(cognome));
//    }
//
//    public List<ClienteDto> findByNomeAndCognome(final String nome, final String cognome) {
//        if (nome != null && cognome != null) {
//            return clientewithMapStruct
//                    .toDtoList(clienteRepository
//                            .findByNomeAndCognome(nome, cognome));
//        } else {
//            return clientewithMapStruct
//                    .toDtoList(clienteRepository.findAll());
//        }
//    }

//    public List<ClienteDto> findByNomeOrCognome(final String nome, final String cognome) {
//        if (nome != null && cognome != null) {
//            return clientewithMapStruct
//                    .toDtoList(clienteRepository
//                            .findByNomeOrCognome(nome, cognome));
//        } else if (nome != null) {
//            return clientewithMapStruct.toDtoList(clienteRepository.findByNome(nome));
//        } else if (cognome != null) {
//            return clientewithMapStruct.toDtoList(clienteRepository.findByCognome(cognome));
//        } else {
//            return clientewithMapStruct
//                    .toDtoList(clienteRepository.findAll());
//        }
//    }

//    public List<ClienteDto> findByAzienda(final String azienda) {
//        return clientewithMapStruct.toDtoList(clienteRepository.findByAzienda(azienda));
//    }

    public List<ClienteDto> createCliente(final ClienteDto clienteDto) {
        Cliente cliente = clientewithMapStruct.toEntity(clienteDto);
        clienteRepository.save(cliente);
        return getAllCLienti();
    }

    public List<ClienteDto> updateClienteById(final ClienteDto newClienteDto, final Integer clienteId) {
        final Optional<Cliente> clienteToUpdate = clienteRepository.findById(clienteId);
        if (clienteToUpdate.isPresent()) {
            final Cliente clientePreso = clienteToUpdate.get();
            clientePreso.setNome(newClienteDto.getNome());
            clientePreso.setCognome(newClienteDto.getCognome());
            clientePreso.setAzienda(newClienteDto.getAzienda());
            clienteRepository.save(clientePreso);
        } else {
            throw new NullPointerException("Cliente non trovato");
        }
        return getAllCLienti();
    }

    public List<ClienteDto> deleteCliente(final Integer clienteId) {
        final Optional<Cliente> clienteToDelete = clienteRepository.findById(clienteId);
        if (clienteToDelete.isPresent()) {
            final Cliente clientePreso = clienteToDelete.get();
            clienteRepository.delete(clientePreso);
        } else {
            throw new NullPointerException("Cliente non trovato");
        }
        return getAllCLienti();
    }

//    public List<ClienteDto> findBy(final ClienteParams params) {
//        return clientewithMapStruct
//                .toDtoList(clienteRepository
//                        .findByNomeAndCognome(params.getNome(), params.getCognome()));
//    }

//    public List<ClienteDto> options(final ClienteParams params) {
//        if (Boolean.TRUE.equals(params.getUseAnd())) {
//            return this.findByNomeAndCognome(params.getNome(), params.getCognome());
//        } else {
//            return this.findByNomeOrCognome(params.getNome(), params.getCognome());
//        }
//    }

    public List<ClienteDto> withSpecifications(final ClienteParams params) {
        return clientewithMapStruct.toDtoList(clienteRepository.findAll(params.toSpecification()));
    }
}

