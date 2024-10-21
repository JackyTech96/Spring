package it.objectmethod.spring_tutorial.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDto {

    private String nome;
    private String cognome;
    private String azienda;

}
