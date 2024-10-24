package it.objectmethod.spring_tutorial.service;

import it.objectmethod.spring_tutorial.dto.DipendenteDto;
import it.objectmethod.spring_tutorial.entity.Dipendente;
import it.objectmethod.spring_tutorial.filter.DipendenteParams;
import it.objectmethod.spring_tutorial.mapper.DipendenteMapperWithMapStruct;
import it.objectmethod.spring_tutorial.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Convenzioni:
 * 1) Le classi annotate con @Service, avranno come nome Oggetto + Service --> DipendenteService
 * 2) Le classi annotate con @Repository, avranno come nome Oggetto + Repository --> DipendenteRepository
 * 3) Le classi annotate con @RestController/@Controller, avranno come nome Oggetto + Controller --> DipendenteController
 * 4) Le classi annotate con @Entity, avranno come nome Oggetto + Entity --> DipendenteEntity
 * 5) Le classi che saranno restituite dal controller (ovvero i DTO --> Data Transfer Object),
 * avranno come nome Oggetto + Dto --> DipendenteDto
 */
@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private DipendenteMapperWithMapStruct dipendenteMapperWithMapStruct;

    public List<DipendenteDto> getAllDipendenti() {
        List<Dipendente> dipendenti = dipendenteRepository.findAll();

        return dipendenteMapperWithMapStruct.toDtoList(dipendenti);
    }

    public DipendenteDto findDipendenteById(final Integer dipendenteId) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId).orElseThrow();
        return dipendenteMapperWithMapStruct.toDto(dipendente);
    }

//    public List<DipendenteDto> findByNome(final String nome) {
//      final List<Dipendente> entities = dipendenteRepository.findByNome(nome);
//        final List<DipendenteDto> toDtos = dipendenteMapperWithMapStruct.toDtoList(entities);
//        return dipendenteMapperWithMapStruct.toDtoList(dipendenteRepository.findByNome(nome));
//    }

//    public List<DipendenteDto> findBy(DipendenteParams params) {
//        return dipendenteMapperWithMapStruct
//                .toDtoList((dipendenteRepository
//                        .findByNomeAndEmail(params.getNome(), params.getEmail())));
//    }


    public List<DipendenteDto> createDipendente(final DipendenteDto dipendenteDto) {
        Dipendente dipendente = dipendenteMapperWithMapStruct.toEntity(dipendenteDto);
        dipendenteRepository.save(dipendente);
        return getAllDipendenti();
    }

    public List<DipendenteDto> updateDipendenteById(final Integer dipendenteId, final Dipendente newDipendente) {
        final Optional<Dipendente> dipendenteToUpdate = dipendenteRepository.findById(dipendenteId);
        if (dipendenteToUpdate.isPresent()) {
            final Dipendente dipendentePreso = dipendenteToUpdate.get();
            dipendentePreso.setNome(newDipendente.getNome());
            dipendentePreso.setCognome(newDipendente.getCognome());
            dipendentePreso.setCf(newDipendente.getCf());
            dipendentePreso.setEmail(newDipendente.getEmail());
            dipendentePreso.setTelefono(newDipendente.getTelefono());
            dipendenteRepository.save(dipendentePreso);
        } else {
            throw new NullPointerException("Dipendente non trovato");
        }
        return getAllDipendenti();
    }

    public List<DipendenteDto> deleteDipendente(final Integer dipendenteId) {
        final Optional<Dipendente> dipendenteToDelete = dipendenteRepository.findById(dipendenteId);
        if (dipendenteToDelete.isPresent()) {
            final Dipendente dipendentePreso = dipendenteToDelete.get();
            dipendenteRepository.delete(dipendentePreso);
        } else {
            throw new NullPointerException("Utente da eliminare non trovato");
        }
        return getAllDipendenti();
    }

    public List<DipendenteDto> withSpecifications(final DipendenteParams params) {
        return dipendenteMapperWithMapStruct.toDtoList(dipendenteRepository.findAll(params.toSpecification()));
    }
}
