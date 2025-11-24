package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Funcionario;
import br.com.hemn.backend.service.FuncionarioService;

/**
 * Controlador responsável por gerenciar as operações relacionadas à entidade {@link Funcionario}.
 * <p>
 * Disponibiliza endpoints para listagem e consulta de funcionários registrados no sistema.
 * </p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    /** Serviço responsável pelo gerenciamento de funcionários. */
    @Autowired
    private FuncionarioService funcionarioService;

    /**
     * Retorna a lista completa de funcionários cadastrados.
     *
     * @return lista de funcionários
     */
    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    /**
     * Busca um funcionário pelo seu identificador.
     *
     * @param id identificador do funcionário
     * @return funcionário encontrado ou {@code 404 Not Found} caso não exista
     */
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
