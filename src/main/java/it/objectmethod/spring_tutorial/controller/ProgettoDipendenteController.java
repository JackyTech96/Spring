package it.objectmethod.spring_tutorial.controller;

import it.objectmethod.spring_tutorial.dto.ProgettoDipendenteDto;
import it.objectmethod.spring_tutorial.entity.Dipendente;
import it.objectmethod.spring_tutorial.entity.ProgettoDipendente;
import it.objectmethod.spring_tutorial.service.ProgettoDipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/progetto-dipendente")
@CrossOrigin
public class ProgettoDipendenteController {
    @Autowired
    ProgettoDipendenteService progettoDipendenteService;

    @GetMapping("")
    public List<ProgettoDipendenteDto> getAllProgettiDipendente() {
        return progettoDipendenteService.getAllProgettiDipendenti();
    }

//    @GetMapping("/dipendenti/{progettoId}")
//    public List<Dipendente> findDipendentiByProgettoId(@PathVariable Integer progettoId) {
//        return progettoDipendenteService.findDipendentiByProgettoId(progettoId);
//    }

}
