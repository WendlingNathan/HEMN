package br.com.hemn.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Produto;
import br.com.hemn.backend.repository.ProdutoRepository;

/**
 * Serviço responsável pela lógica de negócio da entidade {@link Produto}.
 *
 * <p>Oferece operações de CRUD e consultas por nome, servindo como camada intermediária
 * entre controllers e repositórios.</p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Lista todos os produtos.
     *
     * @return lista de produtos
     */
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    /**
     * Busca um produto pelo ID.
     *
     * @param id identificador do produto
     * @return produto encontrado
     */
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    /**
     * Salva ou atualiza um produto.
     *
     * @param produto objeto a ser salvo
     * @return produto persistido
     */
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    /**
     * Exclui um produto pelo ID.
     *
     * @param id identificador do produto
     */
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
