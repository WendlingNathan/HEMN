package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.Ingrediente;

/**
 * Repositório responsável pela persistência e consultas relacionadas
 * à entidade {@link Ingrediente}.
 *
 * <p>Inclui métodos padrão do Spring Data JPA, além de um método
 * específico para busca parcial por nome ignorando diferenças de
 * maiúsculas e minúsculas.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    /**
     * Busca ingredientes cujo nome contenha o texto informado,
     * ignorando diferenças de capitalização.
     *
     * @param nome_ing trecho do nome a ser pesquisado
     * @return lista de ingredientes correspondentes
     */
    List<Ingrediente> findByNomeIngContainingIgnoreCase(String nome_ing);
}
