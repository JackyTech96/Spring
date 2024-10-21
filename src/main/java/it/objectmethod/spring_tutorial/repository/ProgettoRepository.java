package it.objectmethod.spring_tutorial.repository;

import it.objectmethod.spring_tutorial.entity.Progetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgettoRepository extends JpaRepository<Progetto, Integer> {
}
