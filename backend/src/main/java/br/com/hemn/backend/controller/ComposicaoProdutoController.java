package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.ComposicaoProduto;
import br.com.hemn.backend.repository.ComposicaoProdutoRepository;
@RestController
@RequestMapping("/composicaoproduto")
public class ComposicaoProdutoController {

		@Autowired
		private ComposicaoProdutoRepository ComposicaoProdutoRepository;

		@GetMapping
		public List<ComposicaoProduto> listarTodos() {
			return ComposicaoProdutoRepository.findAll();
		}
		
}
