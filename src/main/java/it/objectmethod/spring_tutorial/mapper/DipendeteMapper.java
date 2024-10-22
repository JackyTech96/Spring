//package it.objectmethod.spring_tutorial.mapper;
//
//import it.objectmethod.spring_tutorial.dto.DipendenteDto;
//import it.objectmethod.spring_tutorial.entity.Dipendente;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DipendeteMapper implements BaseMappingMethod<DipendenteDto, Dipendente> {
//    @Override
//    public DipendenteDto toDto(Dipendente dipendente) {
//        DipendenteDto dto = new DipendenteDto();
//        dto.setNome(dipendente.getNome());
//        dto.setCognome(dipendente.getCognome());
//        dto.setEmail(dipendente.getEmail());
//        return dto;
//    }
//
//    @Override
//    public List<DipendenteDto> toDtoList(List<Dipendente> dipendentes) {
//        List<DipendenteDto> dtoList = new ArrayList<>();
//        for (Dipendente dipendente : dipendentes) {
//            dtoList.add(toDto(dipendente));
//        }
//        return dtoList;
//    }
//
//    @Override
//    public Dipendente toEntity(DipendenteDto dipendenteDto) {
//        Dipendente dipendente = new Dipendente();
//        dipendente.setNome(dipendenteDto.getNome());
//        dipendente.setCognome(dipendenteDto.getCognome());
//        dipendente.setEmail(dipendenteDto.getEmail());
//        return dipendente;
//    }
//
//    @Override
//    public List<Dipendente> toEntityList(List<DipendenteDto> dipendenteDtos) {
//        List<Dipendente> dipendentes = new ArrayList<>();
//        for (DipendenteDto dto:dipendenteDtos){
//            dipendentes.add(toEntity(dto));
//        }
//        return dipendentes;
//    }
//}
