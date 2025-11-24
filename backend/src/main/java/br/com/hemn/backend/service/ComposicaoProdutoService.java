package br.com.hemn.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.ComposicaoProduto;
import br.com.hemn.backend.repository.ComposicaoProdutoRepository;

/**
 * Serviço responsável pela lógica de negócio da entidade {@link ComposicaoProduto}.
 *
 * <p>Gerencia operações de CRUD e consultas específicas associadas
 * aos ingredientes dos produtos.</p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Service
public class ComposicaoProdutoService {

    @Autowired
    private ComposicaoProdutoRepository composicaoProdutoRepository;

    /**
     * Retorna todas as composições de produto cadastradas.
     *
     * @return lista de composições
     */
    public List<ComposicaoProduto> listarTodos() {
        return composicaoProdutoRepository.findAll();
    }

    /**
     * Busca uma composição pelo ID.
     *
     * @param id identificador da composição
     * @return composição encontrada
     */
    public Optional<ComposicaoProduto> buscarPorId(Long id) {
        return composicaoProdutoRepository.findById(id);
    }


    /**
     * Salva ou atualiza uma composição.
     *
     * @param composicao objeto a ser persistido
     * @return composição salva
     */
    public ComposicaoProduto salvar(ComposicaoProduto composicao) {
        return composicaoProdutoRepository.save(composicao);
    }

    /**
     * Remove uma composição do sistema.
     *
     * @param id identificador da composição
     */
    public void deletar(Long id) {
        composicaoProdutoRepository.deleteById(id);
    }
}
