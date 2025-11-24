package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.ComposicaoProduto;
import br.com.hemn.backend.service.ComposicaoProdutoService;

/**
 * Controlador responsável por gerenciar as operações ligadas à entidade
 * {@link ComposicaoProduto}.
 *
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

    /** Serviço responsável pela lógica de negócios de ComposicaoProduto. */
    @Autowired
    private ComposicaoProdutoService composicaoProdutoService;

    /**
     * Retorna todas as composições de produtos registradas no sistema.
     *
     * @return lista contendo todas as instâncias de {@link ComposicaoProduto}.
     */
    @GetMapping
    public List<ComposicaoProduto> listarTodos() {
        return composicaoProdutoService.listarTodos();
    }

    /**
     * Busca uma composição específica pelo seu identificador.
     *
     * @param id identificador único da composição
     * @return {@link ResponseEntity} contendo a composição encontrada ou
     *         {@code 404 Not Found} caso não exista
     */
    @GetMapping("/{id}")
    public ResponseEntity<ComposicaoProduto> buscarPorId(@PathVariable Long id) {
        return composicaoProdutoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
