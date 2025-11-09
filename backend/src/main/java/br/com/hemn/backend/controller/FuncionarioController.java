package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Funcionario;
import br.com.hemn.backend.repository.FuncionarioRepository;

	@RestController
	@RequestMapping("/funcionario")
	public class FuncionarioController {

	    @Autowired
	    private FuncionarioRepository funcionarioRepository;

	    @GetMapping
	    public List<Funcionario> listarTodos() {
	        return funcionarioRepository.findAll();
	    }

	    @GetMapping("/{id}")
		public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
			Optional<Funcionario> funcionario =funcionarioRepository.findById(id);
			return funcionario.map(ResponseEntity::ok)
						   .orElse(ResponseEntity.notFound().build());
		}
	}

