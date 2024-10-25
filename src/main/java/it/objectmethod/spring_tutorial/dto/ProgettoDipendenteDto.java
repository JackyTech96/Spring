package it.objectmethod.spring_tutorial.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProgettoDipendenteDto {
    private Integer progettoId;
    private Integer dipendenteId;
    private ProgettoDto progettoDto;
    private DipendenteDto dipendenteDto;
}
