package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Pagamento;
import br.com.hemn.backend.service.PagamentoService;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Pagamento}.
 * <p>
 * Disponibiliza endpoints para listagem e consulta de pagamentos registrados no sistema.
 * </p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    /** Serviço da entidade Pagamento. */
    @Autowired
    private PagamentoService pagamentoService;

    /**
     * Retorna todos os pagamentos cadastrados.
     *
     * @return lista de pagamentos
     */
    @GetMapping
    public List<Pagamento> listarTodos() {
        return pagamentoService.listarTodos();
    }

    /**
     * Busca um pagamento pelo seu identificador.
     *
     * @param id identificador único do pagamento
     * @return {@link ResponseEntity} com o pagamento encontrado ou 404 caso não exista
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable Long id) {
        return pagamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
