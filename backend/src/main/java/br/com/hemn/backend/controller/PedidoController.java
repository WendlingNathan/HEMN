package br.com.hemn.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Pedido;
import br.com.hemn.backend.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")

public class PedidoController {

	@Autowired
	private PedidoRepository PedidoRepository;

	@GetMapping
	public List<Pedido> listarTodos() {
		return PedidoRepository.findAll();
	}
}
