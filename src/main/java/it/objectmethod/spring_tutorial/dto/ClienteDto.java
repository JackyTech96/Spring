package it.objectmethod.spring_tutorial.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ClienteDto {

    private String nome;
    private String cognome;
    private String azienda;
    private List<ProgettoDto> progetti = new ArrayList<>();
}
