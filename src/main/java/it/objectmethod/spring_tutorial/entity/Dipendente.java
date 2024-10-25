package it.objectmethod.spring_tutorial.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dipendente")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dipendente_id")
    private Integer dipendenteId;

    @Column(name = "nome", length = 20)
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "cf", length = 16)
    private String cf;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")

    private String telefono;

    @Column(name = "ruolo")
    private String ruolo;

    @OneToMany(mappedBy = "dipendente", fetch = FetchType.LAZY)
    private List<ProgettoDipendente> progettiDipendentiList;

}
