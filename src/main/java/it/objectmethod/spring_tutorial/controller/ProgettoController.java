package it.objectmethod.spring_tutorial.controller;

import it.objectmethod.spring_tutorial.dto.ProgettoDto;
import it.objectmethod.spring_tutorial.service.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/progetto")
@RestController
public class ProgettoController {
    @Autowired
    private ProgettoService progettoService;

    @GetMapping("")
    public List<ProgettoDto> getAllProgetti() {
        return progettoService.getAllProgetti();
    }

    @GetMapping("/{id}")
    public ProgettoDto findProgettoById(@PathVariable final Integer id) {
        return progettoService.findProgettoById(id);
    }

    @GetMapping("filterByNome")
    public List<ProgettoDto> findByNome(@RequestParam final String nome) {
        return progettoService.findProgettoByName(nome);
    }

    @PostMapping("/create")
    public List<ProgettoDto> createProgetto(@RequestBody final ProgettoDto progettoDto) {
        return progettoService.createProgetto(progettoDto);
    }

    @PutMapping("/put/{progettoId}")
    public List<ProgettoDto> updateProgetto(@RequestBody final ProgettoDto newProgettoDto, @PathVariable final Integer progettoId) {
        return progettoService.updateProgettoById(newProgettoDto, progettoId);
    }

    @DeleteMapping("/delete/{id}")
    public List<ProgettoDto> deleteProgetto(@PathVariable(name = "id") final Integer progettoId) {
        return progettoService.deleteProgetto(progettoId);
    }
}




