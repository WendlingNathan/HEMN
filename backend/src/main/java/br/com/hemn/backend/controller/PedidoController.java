package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Pedido;
import br.com.hemn.backend.service.PedidoService;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Pedido}.
 * <p>
 * Disponibiliza endpoints para listagem e consulta de pedidos registrados no sistema.
 * </p>
 * 
 * authors...
 */
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    /** Serviço da entidade Pedido. */
    @Autowired
    private PedidoService pedidoService;

    /**
     * Retorna todos os pedidos cadastrados.
     *
     * @return lista de pedidos
     */
    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    /**
     * Busca um pedido específico pelo seu identificador.
     *
     * @param id identificador do pedido
     * @return {@link ResponseEntity} contendo o pedido encontrado ou 404 caso não exista.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
