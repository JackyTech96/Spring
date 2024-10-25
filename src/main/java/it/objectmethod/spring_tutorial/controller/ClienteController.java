package it.objectmethod.spring_tutorial.controller;

import it.objectmethod.spring_tutorial.dto.ClienteDto;
import it.objectmethod.spring_tutorial.excepction.handler.ResponseUtil;
import it.objectmethod.spring_tutorial.param.ClienteParams;
import it.objectmethod.spring_tutorial.response.ResponseWrapper;
import it.objectmethod.spring_tutorial.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseWrapper<ClienteDto>> findClienteById(@PathVariable final Integer id, final HttpServletRequest request) {
        return ResponseUtil
                .execute(() -> new ResponseEntity<>(clienteService.findClienteById(id), HttpStatus.OK), request);
//        ResponseWrapper<ClienteDto> response = clienteService.findClienteById(id);
//        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/filterByNome")
//    public List<ClienteDto> findByNome(@RequestParam final String nome) {
//        return clienteService.findByNome(nome);
//    }
//
//
//    @GetMapping("/filterByCognome")
//    public List<ClienteDto> findByCognome(@RequestParam final String cognome) {
//        return clienteService.findByCognome(cognome);
//    }


//    @GetMapping("/filterByAzienda")
//    public List<ClienteDto> findByAzienda(@RequestParam final String azienda) {
//        return clienteService.findByAzienda(azienda);
//    }

    @PostMapping("")
    public ResponseEntity<List<ClienteDto>> createCliente(@RequestBody ClienteDto clienteDto, final HttpServletRequest request) {
        return ResponseUtil
                .execute(() -> new ResponseEntity<>(clienteService.createCliente(clienteDto), HttpStatus.CREATED), request);
    }

    @PutMapping("{id}")
    public List<ClienteDto> updateCliente(@RequestBody final ClienteDto newClienteDto,
                                          @PathVariable final Integer clienteId) {
        return clienteService.updateClienteById(newClienteDto, clienteId);
    }


//    @GetMapping("/filterBy")
//    public List<ClienteDto> findBy(@Valid final ClienteParams params) {
//        return clienteService.options(params);
//    }


    @DeleteMapping("/{id}")
    public List<ClienteDto> deleteCliente(@PathVariable(name = "id") final Integer clienteId) {
        return clienteService.deleteCliente(clienteId);
    }

    @GetMapping("/specifications")
    public List<ClienteDto> withSpecifications(@Valid final ClienteParams params) {
        return clienteService.withSpecifications(params);
    }
}
