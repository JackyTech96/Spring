package it.objectmethod.spring_tutorial.controller;

import it.objectmethod.spring_tutorial.dto.DipendenteDto;
import it.objectmethod.spring_tutorial.entity.Dipendente;
import it.objectmethod.spring_tutorial.excepction.handler.ResponseUtil;
import it.objectmethod.spring_tutorial.param.DipendenteParams;
import it.objectmethod.spring_tutorial.service.DipendenteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DipendenteDto> findById(@PathVariable final Integer id, HttpServletRequest request) {
        return ResponseUtil
                .execute(() -> new ResponseEntity<>(dipendenteService.findDipendenteById(id), HttpStatus.OK), request);
    }

//    @GetMapping("/filterByNome")
//    public List<DipendenteDto> findByNome(@RequestParam final String nome) {
//        return dipendenteService.findByNome(nome);
//    }

//    @GetMapping("/filterBy")
//    public List<DipendenteDto> findBy(final DipendenteParams params) {
//        return dipendenteService.findBy(params);
//    }

    @PostMapping("")
    public List<DipendenteDto> createDipendente(@RequestBody DipendenteDto dipendenteDto) {
        return dipendenteService.createDipendente(dipendenteDto);
    }

    @PutMapping("/{id}")
    public List<DipendenteDto> updateDipendente(@RequestParam final Integer dipendenteId, @RequestBody final Dipendente newDipendente) {
        return dipendenteService.updateDipendenteById(dipendenteId, newDipendente);
    }

    @DeleteMapping("/{id}")
    public List<DipendenteDto> deleteDipendente(@PathVariable(name = "id") final Integer dipendenteId) {
        return dipendenteService.deleteDipendente(dipendenteId);
    }

    @GetMapping("/specifications")
    public ResponseEntity<List<DipendenteDto>> withSpecifications(@Valid final DipendenteParams params, final HttpServletRequest request) {
        return ResponseUtil
                .execute(() -> new ResponseEntity<>(dipendenteService.withSpecifications(params), HttpStatus.OK), request);
    }
}
