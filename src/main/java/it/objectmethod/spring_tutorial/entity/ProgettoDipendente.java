package it.objectmethod.spring_tutorial.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "progetto_dipendente")
public class ProgettoDipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progetto_dipendente_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "progetto_id", nullable = false, referencedColumnName = "progetto_id")
    private Progetto progetto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dipendente_id", nullable = false)
    private Dipendente dipendente;

}
