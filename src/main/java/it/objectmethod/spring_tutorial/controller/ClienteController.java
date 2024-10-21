package it.objectmethod.spring_tutorial.controller;

import it.objectmethod.spring_tutorial.dto.ClienteDto;
import it.objectmethod.spring_tutorial.filter.ClienteParams;
import it.objectmethod.spring_tutorial.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public List<ClienteDto> getAllClienti() {
        return clienteService.getAllCLienti();
    }

    @GetMapping("/{id}")
    public ClienteDto findClienteById(@PathVariable final Integer id) {
        return clienteService.findClienteById(id);
    }

    @GetMapping("/filterByNome")
    public List<ClienteDto> findByNome(@RequestParam final String nome) {
        return clienteService.findByNome(nome);
    }

    @PostMapping("/create")
    public List<ClienteDto> createCliente(@RequestBody ClienteDto clienteDto) {
        return clienteService.createCliente(clienteDto);
    }

    @PutMapping("/put/{clienteId}/{pippo}")
    public List<ClienteDto> updateCliente(@RequestBody final ClienteDto newClienteDto,
                                          @PathVariable final Integer clienteId) {
        return clienteService.updateClienteById(newClienteDto, clienteId);
    }

    @GetMapping("/filter")
    public List<ClienteDto> updateCliente(final ClienteParams params) {
        return clienteService.findBy(params);
    }

    @DeleteMapping("/delete/{id}")
    public List<ClienteDto> deleteCliente(@PathVariable(name = "id") final Integer clienteId) {
        return clienteService.deleteCliente(clienteId);
    }
}
