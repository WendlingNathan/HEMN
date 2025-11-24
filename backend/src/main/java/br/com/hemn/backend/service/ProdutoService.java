package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Produto;
import br.com.hemn.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeProdContainingIgnoreCase(nome);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);

        produto.setNome_prod(produtoAtualizado.getNome_prod());
        produto.setDescricao_prod(produtoAtualizado.getDescricao_prod());
        produto.setPreco_prod(produtoAtualizado.getPreco_prod());
        produto.setTipo_prod(produtoAtualizado.getTipo_prod());
        produto.setComposicao_produto(produtoAtualizado.getComposicao_produto());

        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id);
        produtoRepository.delete(produto);
    }
}
