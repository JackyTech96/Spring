package it.objectmethod.spring_tutorial.repository;

import it.objectmethod.spring_tutorial.entity.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
    List<Dipendente> findByNome(String nome);
}
