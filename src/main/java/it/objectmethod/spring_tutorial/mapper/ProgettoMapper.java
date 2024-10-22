//package it.objectmethod.spring_tutorial.mapper;
//
//import it.objectmethod.spring_tutorial.dto.ProgettoDto;
//import it.objectmethod.spring_tutorial.entity.Progetto;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class ProgettoMapper implements BaseMappingMethod<ProgettoDto, Progetto> {
//
//    @Override
//    public ProgettoDto toDto(Progetto progetto) {
//        ProgettoDto dto = new ProgettoDto();
//        dto.setNome(progetto.getNome());
//        dto.setDescrizione(progetto.getDescrizione());
//        return dto;
//    }
//
//    @Override
//    public List<ProgettoDto> toDtoList(List<Progetto> progettos) {
//        List<ProgettoDto> dtoList = new ArrayList<>();
//        for (Progetto progetto : progettos) {
//            dtoList.add(toDto(progetto));
//        }
//        return dtoList;
//    }
//
//    @Override
//    public Progetto toEntity(ProgettoDto progettoDto) {
//        Progetto progetto = new Progetto();
//        progetto.setNome(progettoDto.getNome());
//        progetto.setDescrizione(progettoDto.getDescrizione());
//        return progetto;
//    }
//
//    @Override
//    public List<Progetto> toEntityList(List<ProgettoDto> progettoDtos) {
//        List<Progetto> progettos = new ArrayList<>();
//        for(ProgettoDto dto : progettoDtos){
//            progettos.add(toEntity(dto));
//        }
//        return progettos;
//    }
//}
