package it.objectmethod.spring_tutorial.service;

import it.objectmethod.spring_tutorial.dto.ProgettoDto;
import it.objectmethod.spring_tutorial.entity.Progetto;
import it.objectmethod.spring_tutorial.mapper.ProgettoMapper;
import it.objectmethod.spring_tutorial.repository.ProgettoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgettoService {

    @Autowired
    private ProgettoRepository progettoRepository;
    @Autowired
    private ProgettoMapper progettoMapper;

    public List<ProgettoDto> getAllProgetti() {
        List<Progetto> progetti = progettoRepository.findAll();
        return progettoMapper.toDtoList(progetti);
    }

    public ProgettoDto findProgettoById(final Integer progettoId) {
        Progetto progetto = progettoRepository.findById(progettoId).orElseThrow();
        return progettoMapper.toDto(progetto);
    }

    public 

    public List<ProgettoDto> createProgetto(final ProgettoDto progettoDto) {
        Progetto progetto = progettoMapper.toEntity(progettoDto);
        progettoRepository.save(progetto);
        return getAllProgetti();
    }

    public List<ProgettoDto> updateProgettoById(final ProgettoDto newProgettoDto, final Integer progettoId) {
        final Optional<Progetto> progettoToUpdate = progettoRepository.findById(progettoId);
        if (progettoToUpdate.isPresent()) {
            final Progetto progettoPreso = progettoToUpdate.get();
            progettoPreso.setNome(newProgettoDto.getNome());
            progettoPreso.setDescrizione(newProgettoDto.getDescrizione());
            progettoRepository.save(progettoPreso);
        } else {
            throw new NullPointerException("Progetto non trovato");
        }
        return getAllProgetti();
    }

    public List<ProgettoDto> deleteProgetto(final Integer progettoId) {
        final Optional<Progetto> progettoToDelete = progettoRepository.findById(progettoId);
        if (progettoToDelete.isPresent()) {
            final Progetto progettoPreso = progettoToDelete.get();
            progettoRepository.delete(progettoPreso);
        } else {
            throw new NullPointerException("Progetto non trovato");
        }
        return getAllProgetti();
    }
}
