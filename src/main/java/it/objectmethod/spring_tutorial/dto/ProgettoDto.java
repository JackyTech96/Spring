package it.objectmethod.spring_tutorial.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProgettoDto {
    private String nome;
    private String descrizione;
}
