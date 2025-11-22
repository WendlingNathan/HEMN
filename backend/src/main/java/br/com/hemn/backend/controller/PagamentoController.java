package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Pagamento;
import br.com.hemn.backend.repository.PagamentoRepository;

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

	/** Repositório da entidade Pagamento. */
    @Autowired
    private PagamentoRepository pagamentoRepository;

    /**
     * Retorna todos os pagamentos cadastrados.
     *
     * @return lista de pagamentos ou {@code 404 Not Found} caso o pagamento não exista.
     */
    @GetMapping
    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }
    
    /**
     * Busca um pagamento específico pelo seu identificador.
     *
     * @param id Identificador único do pagamento a ser buscada.
     * @return {@link ResponseEntity} contendo o pagamento encontrado ou
     *         {@code 404 Not Found} caso o pagamento não exista.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        return pagamento.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
