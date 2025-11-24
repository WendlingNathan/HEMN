package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.ComposicaoProduto;
import br.com.hemn.backend.repository.ComposicaoProdutoRepository;

@Service
public class ComposicaoProdutoService {

    @Autowired
    private ComposicaoProdutoRepository composicaoProdutoRepository;

    public List<ComposicaoProduto> listarTodos() {
        return composicaoProdutoRepository.findAll();
    }

    public ComposicaoProduto buscarPorId(Long id) {
        return composicaoProdutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Composição de produto não encontrada: ID " + id));
    }

    public ComposicaoProduto salvar(ComposicaoProduto composicao) {
        return composicaoProdutoRepository.save(composicao);
    }

    public void deletar(Long id) {
        composicaoProdutoRepository.deleteById(id);
    }

    public List<ComposicaoProduto> buscarPorIngrediente(Long idIngrediente) {
        return composicaoProdutoRepository.findByIngrediente_IdIng(idIngrediente);
    }
}
