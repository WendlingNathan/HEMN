package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.Cliente;

/**
 * Repositório responsável por realizar operações de acesso e manipulação
 * de dados da entidade {@link Cliente}.  
 *
 * <p>Herda os métodos padrão do Spring Data JPA, permitindo operações como
 * salvar, buscar, atualizar e deletar registros sem necessidade de implementação manual.</p>
 *
 * <p>Inclui também um método de consulta customizado para pesquisa de clientes
 * pelo nome, ignorando diferenças de caixa.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /**
     * Busca clientes cujo nome contenha o valor informado,
     * ignorando diferenças entre letras maiúsculas e minúsculas.
     *
     * @param nome_cli trecho do nome a ser pesquisado
     * @return lista de clientes que correspondem ao critério
     */
    List<Cliente> findByNomeCliContainingIgnoreCase(String nome_cli);
}
