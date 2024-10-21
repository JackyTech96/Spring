package it.objectmethod.spring_tutorial.controller;

import it.objectmethod.spring_tutorial.dto.DipendenteDto;
import it.objectmethod.spring_tutorial.entity.Dipendente;
import it.objectmethod.spring_tutorial.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/dipendente")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("")
    public List<DipendenteDto> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/{id}")
    public DipendenteDto findById(@PathVariable final Integer id) {
        return dipendenteService.findDipendenteById(id);
    }

    @GetMapping("/filterByNome")
    public List<DipendenteDto> findByNome(@RequestParam final String nome){
        return dipendenteService.findByNome(nome);
    }
    @PostMapping("/create")
    public List<DipendenteDto> createDipendente(@RequestBody DipendenteDto dipendenteDto) {
        return dipendenteService.createDipendente(dipendenteDto);
    }

    @PutMapping("/put/{dipendenteId}")
    public List<DipendenteDto> updateDipendente(@RequestParam final Integer dipendenteId, @RequestBody final Dipendente newDipendente) {
        return dipendenteService.updateDipendenteById(dipendenteId, newDipendente);
    }

    @DeleteMapping("/delete/{id}")
    public List<DipendenteDto> deleteDipendente(@PathVariable(name = "id") final Integer dipendenteId) {
        return dipendenteService.deleteDipendente(dipendenteId);
    }
}
