package it.objectmethod.spring_tutorial.repository;

import it.objectmethod.spring_tutorial.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "SELECT * From Cliente Where nome = :nome", nativeQuery = true)
    List<Cliente> findByNome(@Param("nome") String nome);
    @Query(value = "SELECT * From Cliente Where cognome = :cognome", nativeQuery = true)
    List<Cliente> findByCognome(@Param("cognome") String cognome);

    @Query(value = "SELECT * From Cliente Where nome = :nome and cognome = :cognome", nativeQuery = true)
    List<Cliente> findByNomeAndCognome(@Param("nome") String nome, @Param("cognome") String cognome);

    @Query(value ="SELECT * From Cliente Where nome = :nome or cognome = :cognome", nativeQuery = true)
    List<Cliente> findByNomeOrCognome(@Param("nome") String nome, @Param("cognome") String cognome);

    @Query(value = "SELECT * From Cliente Where azienda = :azienda", nativeQuery = true)
    List<Cliente> findByAzienda(@Param("azienda") String azienda);

}
