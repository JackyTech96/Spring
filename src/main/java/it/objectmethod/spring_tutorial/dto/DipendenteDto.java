package it.objectmethod.spring_tutorial.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DipendenteDto {

    private String nome;
    private String cognome;
    private String email;


}
