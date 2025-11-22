package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.ComposicaoProduto;
import br.com.hemn.backend.repository.ComposicaoProdutoRepository;

/**
 * Controlador responsável por gerenciar as operações ligadas à entidade
 * {@link ComposicaoProduto}.
 * <p>
 * Disponibiliza endpoints para consulta das composições dos produtos cadastrados,
 * incluindo ingredientes e quantidades utilizadas.
 * </p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/composicaoproduto")
public class ComposicaoProdutoController {

	/** Repositório da entidade ComposicaoProduto. */
    @Autowired
    private ComposicaoProdutoRepository composicaoProdutoRepository;

    /**
     * Retorna todas as composições de produtos registradas no sistema.
     *
     * @return Lista contendo todas as instâncias de {@link ComposicaoProduto} ou 
     *         {@code 404 Not Found} caso a composição não exista.
     */
    @GetMapping
    public List<ComposicaoProduto> listarTodos() {
        return composicaoProdutoRepository.findAll();
    }
    
    /**
     * Busca um composição específica pelo seu identificador.
     *
     * @param id Identificador único da composição a ser buscada.
     * @return {@link ResponseEntity} contendo a composição encontrada ou
     *         {@code 404 Not Found} caso a composição não exista.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ComposicaoProduto> buscarPorId(@PathVariable Long id) {
        Optional<ComposicaoProduto> composicaoProduto = composicaoProdutoRepository.findById(id);
        return composicaoProduto.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}