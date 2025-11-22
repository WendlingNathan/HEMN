package br.com.hemn.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.Pagamento;

/**
 * Repositório responsável pela persistência e consultas relacionadas
 * à entidade {@link Pagamento}.
 *
 * <p>Fornece todos os métodos padrão do Spring Data JPA para operações
 * CRUD e consultas básicas.</p>
 *
 * <p>Este repositório não define métodos adicionais, pois as operações
 * padrão já são suficientes para manipulação de pagamentos.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
