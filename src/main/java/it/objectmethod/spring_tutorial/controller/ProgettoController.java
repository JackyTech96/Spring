package it.objectmethod.spring_tutorial.controller;

import it.objectmethod.spring_tutorial.dto.ClienteDto;
import it.objectmethod.spring_tutorial.dto.ProgettoDto;
import it.objectmethod.spring_tutorial.service.ClienteService;
import it.objectmethod.spring_tutorial.service.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgettoController {
    @Autowired
    private ProgettoService progettoService;

    @GetMapping("api/progetto")
    public List<ProgettoDto> getAllProgetti() {
        return progettoService.getAllProgetti();
    }

    @GetMapping("api/progetto/{id}")
    public ProgettoDto findProgettoById(@PathVariable final Integer id) {
        return progettoService.findProgettoById(id);
    }

    @PostMapping("api/progetto/create")
    public List<ProgettoDto> createProgetto(@RequestBody ProgettoDto progettoDto) {
        return progettoService.createProgetto(progettoDto);
    }

    @PutMapping("api/progetto/put/{progettoId}")
    public List<ProgettoDto> updateProgetto(@RequestBody final ProgettoDto newProgettoDto, @PathVariable final Integer progettoId) {
        return progettoService.updateProgettoById(newProgettoDto, progettoId);
    }

    @DeleteMapping("api/progetto/delete/{id}")
    public List<ProgettoDto> deleteProgetto(@PathVariable(name = "id") final Integer progettoId) {
        return progettoService.deleteProgetto(progettoId);
    }
}




