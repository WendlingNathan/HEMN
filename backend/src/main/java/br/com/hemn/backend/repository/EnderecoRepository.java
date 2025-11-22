package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.Endereco;

/**
 * Repositório responsável pelo gerenciamento de acesso e persistência
 * dos dados relacionados à entidade {@link Endereco}.
 *
 * <p>Fornece operações padrão fornecidas pelo Spring Data JPA,
 * além de consultas personalizadas para filtragem específica.</p>
 *
 * <p>Inclui um método para buscar endereços filtrando simultaneamente
 * por cidade e bairro. Embora o nome do método seja
 * {@code findByCidadeEnd}, a consulta também considera o bairro.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    /**
     * Busca endereços filtrando por cidade e bairro.
     *
     * @param cidade nome da cidade
     * @param bairro nome do bairro
     * @return lista de endereços que correspondam aos filtros
     */
    @Query("SELECT e FROM Endereco e WHERE e.cidade_end = :cidade AND e.bairro_end = :bairro")
    List<Endereco> findByCidadeEnd(@Param("cidade") String cidade, @Param("bairro") String bairro
    );
}
