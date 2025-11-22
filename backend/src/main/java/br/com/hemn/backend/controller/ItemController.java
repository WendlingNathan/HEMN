package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Item;
import br.com.hemn.backend.repository.ItemRepository;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Item}.
 * <p>
 * Disponibiliza endpoints para listagem e consulta de itens registrados no sistema.
 * </p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/item")
public class ItemController {

	/** Repositório da entidade Item. */
    @Autowired
    private ItemRepository itemRepository;

    /**
     * Retorna todos os itens cadastrados.
     *
     * @return lista de itens
     */
    @GetMapping
    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    /**
     * Busca um item pelo seu ID.
     *
     * @param id identificador do item
     * @return item encontrado ou {@code 404 Not Found} caso o item não exista.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
}
