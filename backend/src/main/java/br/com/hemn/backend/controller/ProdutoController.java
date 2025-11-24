package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Produto;
import br.com.hemn.backend.service.ProdutoService;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Produto}.
 * <p>
 * Disponibiliza endpoints para listagem e consulta de produtos registrados no sistema.
 * </p>
 *
 * authors...
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    /** Serviço da entidade Produto. */
    @Autowired
    private ProdutoService produtoService;

    /**
     * Retorna todos os produtos cadastrados.
     *
     * @return lista de produtos
     */
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    /**
     * Busca um produto específico pelo seu identificador.
     *
     * @param id identificador do produto
     * @return produto encontrado ou 404 se não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
