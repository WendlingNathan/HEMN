package br.com.hemn.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.Item;

/**
 * Repositório responsável pela persistência e consultas relacionadas
 * à entidade {@link Item}.
 *
 * <p>Fornece todos os métodos padrão do Spring Data JPA para operações
 * CRUD e consultas básicas.</p>
 *
 * <p>Esta interface não define métodos adicionais, pois as operações
 * padrão já atendem ao necessário para a entidade Item.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
