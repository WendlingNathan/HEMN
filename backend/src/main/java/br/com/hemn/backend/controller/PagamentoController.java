package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Pagamento;
import br.com.hemn.backend.repository.PagamentoRepository;
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
	
				@Autowired
				private PagamentoRepository PagamentoRepository;

				@GetMapping
				public List<Pagamento> listarTodos() {
					return PagamentoRepository.findAll();
				}
}
