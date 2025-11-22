package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemn.backend.model.Produto;

/**
 * Repositório responsável pela persistência e consultas relacionadas
 * à entidade {@link Produto}.
 *
 * <p>Inclui métodos padrão do Spring Data JPA, além de uma consulta
 * personalizada para busca parcial de produtos por nome,
 * ignorando diferenças entre maiúsculas e minúsculas.</p>
 *
 * <p>Utilizado pela camada de serviço e pelos controllers para
 * fornecimento de operações de acesso a dados.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    /**
     * Busca produtos cujo nome contenha o trecho informado,
     * desconsiderando diferenças de capitalização.
     *
     * @param nome_prod trecho do nome do produto a ser pesquisado
     * @return lista de produtos correspondentes ao critério
     */
    List<Produto> findByNomeProdContainingIgnoreCase(String nome_prod);
}
