package it.objectmethod.spring_tutorial.controller;

import it.objectmethod.spring_tutorial.dto.ClienteDto;
import it.objectmethod.spring_tutorial.filter.ClienteParams;
import it.objectmethod.spring_tutorial.response.ResponseWrapper;
import it.objectmethod.spring_tutorial.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseWrapper<ClienteDto>> findClienteById(@PathVariable final Integer id) {
        ResponseWrapper<ClienteDto> response = clienteService.findClienteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/filterByNome")
    public List<ClienteDto> findByNome(@RequestParam final String nome) {
        return clienteService.findByNome(nome);
    }


    @GetMapping("/filterByCognome")
    public List<ClienteDto> findByCognome(@RequestParam final String cognome) {
        return clienteService.findByCognome(cognome);
    }


    @GetMapping("/filterByAzienda")
    public List<ClienteDto> findByAzienda(@RequestParam final String azienda) {
        return clienteService.findByAzienda(azienda);
    }

    @PostMapping("/create")
    public List<ClienteDto> createCliente(@RequestBody ClienteDto clienteDto) {
        return clienteService.createCliente(clienteDto);
    }

    @PutMapping("/put/{clienteId}")
    public List<ClienteDto> updateCliente(@RequestBody final ClienteDto newClienteDto,
                                          @PathVariable final Integer clienteId) {
        return clienteService.updateClienteById(newClienteDto, clienteId);
    }

    @GetMapping("/filter1")



    @DeleteMapping("/delete/{id}")
    public List<ClienteDto> deleteCliente(@PathVariable(name = "id") final Integer clienteId) {
        return clienteService.deleteCliente(clienteId);
    }
}
