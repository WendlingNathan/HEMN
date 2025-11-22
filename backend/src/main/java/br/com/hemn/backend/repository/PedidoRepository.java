package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.Pedido;

/**
 * Repositório responsável pela persistência e consultas relacionadas
 * à entidade {@link Pedido}.
 *
 * <p>Inclui os métodos padrão do Spring Data JPA, além de uma consulta
 * personalizada para filtrar pedidos por status.</p>
 *
 * <p>O status do pedido é armazenado como um caractere, representando
 * o estado atual do pedido dentro do fluxo de atendimento.</p>
 *
 * <p>Este repositório é utilizado pela camada de serviço e pelos 
 * controllers para operações de acesso a dados.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    /**
     * Busca pedidos pelo status informado.
     *
     * @param status_ped código do status do pedido
     * @return lista de pedidos que possuem o status especificado
     */
    List<Pedido> findByStatusPed(String status_ped);
}
