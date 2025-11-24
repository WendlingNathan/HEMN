package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Item;
import br.com.hemn.backend.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    public Item buscarPorId(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado: ID " + id));
    }

    public Item salvar(Item item) {
        return itemRepository.save(item);
    }

    public void deletar(Long id) {
        itemRepository.deleteById(id);
    }
}
