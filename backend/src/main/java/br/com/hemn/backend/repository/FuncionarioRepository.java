package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.Funcionario;

/**
 * Repositório responsável pela persistência e consultas relacionadas
 * à entidade {@link Funcionario}.
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
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    /**
     * Busca funcionários cujo nome contenha o texto informado,
     * ignorando diferenças de capitalização.
     *
     * @param nome_fun trecho do nome a ser pesquisado
     * @return lista de funcionários correspondentes
     */
    List<Funcionario> findByNomeFunContainingIgnoreCase(String nome_fun);
}
