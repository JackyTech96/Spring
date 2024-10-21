package it.objectmethod.spring_tutorial.filter;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteParams {
    private String nome;
    private String cognome;
}
