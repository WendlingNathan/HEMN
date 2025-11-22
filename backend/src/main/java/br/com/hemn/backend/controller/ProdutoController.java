package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Produto;
import br.com.hemn.backend.repository.ProdutoRepository;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Produto}.
 * <p>
 * Disponibiliza endpoints para listagem e consulta de produtos registrados no sistema.
 * </p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {

	/** Repositório da entidade Produto. */
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Retorna todos os produtos cadastrados.
     *
     * @return lista de produtos ou {@code 404 Not Found} caso a composição não exista.
     */
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    
    /**
     * Busca um produto específico pelo seu identificador.
     *
     * @param id Identificador único do produto a ser buscada.
     * @return {@link ResponseEntity} contendo o produto encontrado ou
     *         {@code 404 Not Found} caso o produto não exista.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
