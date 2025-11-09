package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Endereco;
import br.com.hemn.backend.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    @GetMapping("/{id}")
	public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return endereco.map(ResponseEntity::ok)
					   .orElse(ResponseEntity.notFound().build());
	}
}
