package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Endereco;
import br.com.hemn.backend.service.EnderecoService;

/**
 * Controlador responsável por expor endpoints relacionados aos endereços
 * cadastrados no sistema.
 *
 * <p>
 * Permite listar todos os endereços registrados e consultar um endereço
 * específico a partir de seu identificador.
 * </p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    /** Serviço responsável pelo gerenciamento de endereços. */
    @Autowired
    private EnderecoService enderecoService;

    /**
     * Retorna a lista completa de endereços cadastrados.
     *
     * @return lista de objetos {@link Endereco}.
     */
    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoService.listarTodos();
    }

    /**
     * Busca um endereço específico pelo seu identificador.
     *
     * @param id Identificador do endereço.
     * @return {@link ResponseEntity} contendo o endereço encontrado ou
     *         {@code 404 Not Found} caso o endereço não exista.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {
        return enderecoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
