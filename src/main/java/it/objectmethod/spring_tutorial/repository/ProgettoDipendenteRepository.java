package it.objectmethod.spring_tutorial.repository;

import it.objectmethod.spring_tutorial.entity.ProgettoDipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgettoDipendenteRepository extends JpaRepository<ProgettoDipendente, Integer> {

}
