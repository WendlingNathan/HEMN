package br.com.hemn.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hemn.backend.model.Item;
import br.com.hemn.backend.repository.ItemRepository;
	
	@RestController
	@RequestMapping("/item")
	public class ItemController {

	    @Autowired
	    private ItemRepository itemRepository;

	    @GetMapping
	    public List<Item> listarTodos() {
	        return itemRepository.findAll();
	    }

	    @GetMapping("/{id}")
		public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
			Optional<Item> item =itemRepository.findById(id);
			return item.map(ResponseEntity::ok)
						   .orElse(ResponseEntity.notFound().build());
		}
	}

