package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Ingrediente;
import br.com.hemn.backend.repository.IngredienteRepository;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@GetMapping
	public List<Ingrediente> listarTodos() {
		return ingredienteRepository.findAll();
	}
	
    @GetMapping("/{id}")
	public ResponseEntity<Ingrediente> buscarPorId(@PathVariable Long id) {
		Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
		return ingrediente.map(ResponseEntity::ok)
					   .orElse(ResponseEntity.notFound().build());
	}
}
