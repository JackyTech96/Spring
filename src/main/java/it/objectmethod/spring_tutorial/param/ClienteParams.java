package it.objectmethod.spring_tutorial.param;

import it.objectmethod.spring_tutorial.entity.Cliente;
import it.objectmethod.spring_tutorial.entity.Cliente_;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@Data
@NoArgsConstructor
public class ClienteParams {
    @Nullable
    private String nome;
    @Nullable
    private String cognome;


    public Specification<Cliente> toSpecification() {
        return Specification.<Cliente>where(null)
                .and(equalNomeSpecification(nome))
                .and(equalCognomeSpecification(cognome));
    }

    private Specification<Cliente> equalCognomeSpecification(final String cognome) {
        if (cognome == null) return null;
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Cliente_.COGNOME), cognome);
    }

    private Specification<Cliente> equalNomeSpecification(final String nome) {
        if (nome == null) return null;
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Cliente_.NOME), nome);
    }
}
