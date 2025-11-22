package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Endereco;
import br.com.hemn.backend.repository.EnderecoRepository;

/**
 * Controlador responsável por expor endpoints relacionados aos endereços
 * cadastrados no sistema.
 *
 * Disponibiliza endpoints para listagem e consulta de endereços registrados no sistema.
 * </p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	/** Repositório da entidade Endereco. */
    @Autowired
    private EnderecoRepository enderecoRepository;

    /**
     * Retorna a lista completa de endereços cadastrados.
     *
     * @return lista de objetos {@link Endereco}.
     */
    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
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
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }
}
