package it.objectmethod.spring_tutorial.dto;

import it.objectmethod.spring_tutorial.entity.Cliente;
import it.objectmethod.spring_tutorial.entity.ProgettoDipendente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class DipendenteDto {

    private String nome;
    private String cognome;
    private String email;
    private List<ProgettoDto> progettiDipendentiListDto = new ArrayList<>();
}
