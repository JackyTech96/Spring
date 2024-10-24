package it.objectmethod.spring_tutorial.filter;

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

    public Specification<Dipendente> toSpecification() {
        return Specification.<Dipendente>where(null)
                .and(equalIdListSpecification(ids))
//                .and(equalIdSpecification(id))
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
