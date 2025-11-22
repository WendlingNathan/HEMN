package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Pedido;
import br.com.hemn.backend.repository.PedidoRepository;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Pedido}.
 * <p>
 * Disponibiliza endpoints para listagem e consulta de pedidos registrados no sistema.
 * </p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/pedido")
public class PedidoController {

	/** Repositório da entidade Pedido. */
    @Autowired
    private PedidoRepository pedidoRepository;

    /**
     * Retorna todos os pedidos cadastrados.
     *
     * @return lista de pedidos {@code 404 Not Found} caso a composição não exista.
     */
    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    
    /**
     * Busca um pedido específico pelo seu identificador.
     *
     * @param id Identificador único do pedido a ser buscada.
     * @return {@link ResponseEntity} contendo o pedido encontrado ou
     *         {@code 404 Not Found} caso o pedido não exista.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
