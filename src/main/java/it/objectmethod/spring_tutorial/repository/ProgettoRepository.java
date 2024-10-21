package it.objectmethod.spring_tutorial.repository;

import it.objectmethod.spring_tutorial.entity.Progetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgettoRepository extends JpaRepository<Progetto, Integer> {
List<Progetto> findByNome (final String nome);
}
