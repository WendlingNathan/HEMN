package br.com.hemn.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Pedido;
import br.com.hemn.backend.repository.PedidoRepository;

/**
 * Serviço responsável por lidar com as operações e regras de negócio
 * relacionadas à entidade {@link Pedido}.
 *
 * <p>Garante a separação adequada entre a camada web e a camada de
 * persistência, centralizando operações como busca, criação,
 * atualização e remoção de registros.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    /**
     * Retorna todos os pedidos cadastrados.
     *
     * @return lista de pedidos
     */
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    /**
     * Busca um pedido através do seu identificador.
     *
     * @param id identificador do pedido
     * @return {@link Optional} contendo o pedido encontrado, se existir
     */
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    /**
     * Retorna todos os pedidos filtrados por status.
     *
     * @param status_ped status desejado
     * @return lista de pedidos filtrados
     */
    public List<Pedido> listarPorStatus(String status_ped) {
        return pedidoRepository.findByStatusPed(status_ped);
    }

    /**
     * Salva um novo pedido ou atualiza um existente.
     *
     * @param pedido objeto a ser salvo
     * @return pedido salvo
     */
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    /**
     * Exclui um pedido pelo seu identificador.
     *
     * @param id identificador do pedido
     */
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
