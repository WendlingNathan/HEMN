package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.ComposicaoProduto;

/**
 * Repositório responsável por gerenciar o acesso e persistência dos dados
 * relacionados à entidade {@link ComposicaoProduto}.
 *
 * <p>Fornece operações padrão do Spring Data JPA, como salvar, buscar,
 * atualizar e remover registros, além de métodos de consulta personalizados.</p>
 *
 * <p>Inclui um método específico para recuperar composições com base
 * no identificador de um ingrediente associado.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Repository
public interface ComposicaoProdutoRepository extends JpaRepository<ComposicaoProduto, Long> {

    /**
     * Busca todas as composições de produto que utilizam um ingrediente
     * específico, identificado pelo seu ID.
     *
     * @param id_ing identificador do ingrediente
     * @return lista de composições que contenham o ingrediente informado
     */
    List<ComposicaoProduto> findByIngrediente_IdIng(Long id_ing);
}
