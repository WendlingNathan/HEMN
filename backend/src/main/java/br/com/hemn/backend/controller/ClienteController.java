package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Cliente;
import br.com.hemn.backend.service.ClienteService;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Cliente}.
 *
 * <p>
 * Disponibiliza endpoints para listagem e consulta de clientes registrados no sistema.
 * A comunicação com o banco de dados ocorre por meio da camada de serviço.
 * </p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    /** Serviço responsável pelas operações envolvendo {@link Cliente}. */
    @Autowired
    private ClienteService clienteService;

    /**
     * Retorna todos os clientes cadastrados.
     *
     * @return lista contendo todos os {@link Cliente}.
     */
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    /**
     * Busca um cliente pelo seu identificador único.
     *
     * @param id identificador do cliente
     * @return {@link ResponseEntity} contendo o cliente, caso exista;
     *         caso contrário, retorna {@code 404 Not Found}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
        		.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
