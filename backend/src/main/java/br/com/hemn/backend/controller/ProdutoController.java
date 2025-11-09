package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Produto;
import br.com.hemn.backend.repository.ProdutoRepository;
@RestController
@RequestMapping("/produto")
public class ProdutoController {

			@Autowired
			private ProdutoRepository ProdutoRepository;

			@GetMapping
			public List<Produto> listarTodos() {
				return ProdutoRepository.findAll();
			}
			
}

