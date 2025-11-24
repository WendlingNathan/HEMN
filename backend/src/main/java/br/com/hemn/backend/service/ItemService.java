package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Item;
import br.com.hemn.backend.repository.ItemRepository;

/**
 * Serviço responsável pela lógica de negócio da entidade {@link Item}.
 *
 * <p>Fornece operações de CRUD utilizadas no contexto de pedidos e itens associados.</p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Lista todos os itens cadastrados.
     *
     * @return lista de itens
     */
    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    /**
     * Busca um item pelo ID.
     *
     * @param id identificador do item
     * @return item encontrado
     * @throws RuntimeException caso não exista
     */
    public Item buscarPorId(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado: ID " + id));
    }

    /**
     * Salva ou atualiza um item.
     *
     * @param item objeto a ser salvo
     * @return item persistido
     */
    public Item salvar(Item item) {
        return itemRepository.save(item);
    }

    /**
     * Exclui um item pelo ID.
     *
     * @param id identificador do item
     */
    public void deletar(Long id) {
        itemRepository.deleteById(id);
    }
}
