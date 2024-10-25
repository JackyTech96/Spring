package it.objectmethod.spring_tutorial.param;

import it.objectmethod.spring_tutorial.entity.Dipendente;
import it.objectmethod.spring_tutorial.entity.Dipendente_;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Data
@NoArgsConstructor
public class DipendenteParams {
    @Nullable
    private List<Integer> ids;
    @Nullable
    private String nome;
    @Nullable
    private String email;


//    public void validate() {
//
//        if (ids != null) {
//            for (Integer id : ids) {
//                if (id == null || !isNumeric(id.toString())) {
//                    throw new IllegalArgumentException("L'ID deve essere un numero.");
//                }
//            }
//        }
//
//        for (Integer id : ids) {
//            if (id == null || !isNumeric(id.toString())) {
//                throw new IllegalArgumentException("L'ID deve essere un numero.");
//            }
//        }
//
//        if (nome != null && !isStringValid(nome)) {
//            throw new IllegalArgumentException("Il nome deve contenere solo lettere.");
//        }
//
//        if (email != null && !isEmailValid(email)) {
//            throw new IllegalArgumentException("L'email non è valida.");
//        }
//    }

//    private Boolean isStringValid(String value) {
//        return value.matches("^[a-zA-Z]*$");
//    }
//
//    private Boolean isEmailValid(String value) {
//        return value.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
//    }
//
//    public Boolean isNumeric(String value) {
//        return value.matches("^[0-9]*$");
//    }


    public Specification<Dipendente> toSpecification() {
        return Specification.<Dipendente>where(null)
                .and(equalNomeSpecification(nome))
                .and(equalEmailSpecification(email))
                .and(equalIdListSpecification(ids));
//                .and(equalIdSpecification(id))
    }

    public Specification<Dipendente> toCountSpecification() {
        return Specification.<Dipendente>where(null)
                .and(equalNomeSpecification(nome))
                .and(equalEmailSpecification(email));
    }

    public Specification<Dipendente> equalNomeSpecification(final String nome) {
        if (nome == null) return null;
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Dipendente_.NOME), nome);
    }

    public Specification<Dipendente> equalEmailSpecification(final String email) {
        if (email == null) return null;
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Dipendente_.EMAIL), email);
    }

//    public Specification<Dipendente> equalIdSpecification(final Integer id) {
//        if(id == null) return null;
//        return (root, query, criteriaBuilder) ->
//                criteriaBuilder.equal(root.get("id"), id);
//    }

    public Specification<Dipendente> equalIdListSpecification(final List<Integer> ids) {
        if (ids == null) return null;
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.in(root.get("id")).value(ids);
    }
}
