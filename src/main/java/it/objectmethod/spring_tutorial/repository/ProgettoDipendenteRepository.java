package it.objectmethod.spring_tutorial.repository;

import it.objectmethod.spring_tutorial.entity.Dipendente;
import it.objectmethod.spring_tutorial.entity.ProgettoDipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgettoDipendenteRepository extends JpaRepository<ProgettoDipendente, Integer> {

    @Query(value = "SELECT d.* FROM dipendente d INNER JOIN progetto_dipendente pd ON d.dipendente_id = pd.dipendente_id WHERE pd.progetto_id = :progettoId", nativeQuery = true)
    List<Dipendente> findDipendentiByProgettoId(@Param("progettoId") Integer progettoId);

}
