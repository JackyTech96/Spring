package it.objectmethod.spring_tutorial.service;

import it.objectmethod.spring_tutorial.dto.DipendenteDto;
import it.objectmethod.spring_tutorial.dto.ProgettoDipendenteDto;
import it.objectmethod.spring_tutorial.entity.Dipendente;
import it.objectmethod.spring_tutorial.entity.ProgettoDipendente;
import it.objectmethod.spring_tutorial.mapper.ProgettoDipendenteMapperWithMapStruct;
import it.objectmethod.spring_tutorial.repository.ProgettoDipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgettoDipendenteService {

    @Autowired
    ProgettoDipendenteRepository progettoDipendenteRepository;

    @Autowired
    ProgettoDipendenteMapperWithMapStruct progettoDipendenteMapperWithMapStruct;

    public List<ProgettoDipendenteDto> getAllProgettiDipendenti() {
        List<ProgettoDipendente> progettiDipendenti = progettoDipendenteRepository.findAll();
        return progettoDipendenteMapperWithMapStruct.toDtoList(progettiDipendenti);
    }

//    public List<DipendenteDto> findDipendentiByProgettoId(Integer progettoId) {
//        List<ProgettoDipendente> progettiDipendenti = progettoDipendenteRepository.findDipendentiByProgettoId(progettoId);
//        return progettoDipendenteMapperWithMapStruct.toDtoList(progettiDipendenti);
//    }

}
