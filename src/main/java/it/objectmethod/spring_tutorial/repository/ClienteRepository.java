package it.objectmethod.spring_tutorial.repository;

import it.objectmethod.spring_tutorial.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeAndCognome(String nome, String cognome);

    List<Cliente> findaByAzienda(String azienda);
}
