package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Cliente;
import br.com.hemn.backend.repository.ClienteRepository;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Cliente}.
 * <p>
 * Disponibiliza endpoints para listagem e consulta de clientes registrados no sistema.
 * </p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	/** Repositório da entidade Cliente. */
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Retorna uma lista com todos os clientes cadastrados.
     *
     * @return Lista contendo todos os {@link Cliente} presentes no banco de dados.
     */
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Busca um cliente específico pelo seu identificador.
     *
     * @param id Identificador único do cliente a ser buscado.
     * @return {@link ResponseEntity} contendo o cliente encontrado ou
     *         {@code 404 Not Found} caso o cliente não exista.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
