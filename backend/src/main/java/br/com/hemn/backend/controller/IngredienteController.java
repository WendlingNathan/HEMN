package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Ingrediente;
import br.com.hemn.backend.service.IngredienteService;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Ingrediente}.
 * <p>
 * Disponibiliza endpoints para listagem e consulta de ingredientes registrados no sistema.
 * </p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    /** Serviço responsável pela lógica de negócio da entidade Ingrediente. */
    @Autowired
    private IngredienteService ingredienteService;

    /**
     * Retorna todos os ingredientes cadastrados.
     *
     * @return lista de ingredientes
     */
    @GetMapping
    public List<Ingrediente> listarTodos() {
        return ingredienteService.listarTodos();
    }

    /**
     * Busca um ingrediente pelo seu ID.
     *
     * @param id identificador do ingrediente
     * @return ingrediente encontrado ou {@code 404 Not Found} caso não exista
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> buscarPorId(@PathVariable Long id) {
        return ingredienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
