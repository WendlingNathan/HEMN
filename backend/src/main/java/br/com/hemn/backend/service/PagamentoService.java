package br.com.hemn.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Pagamento;
import br.com.hemn.backend.repository.PagamentoRepository;

/**
 * Serviço responsável por concentrar as regras de negócio relacionadas
 * à entidade {@link Pagamento}, evitando que a camada de controle
 * (controllers) trabalhe diretamente com o repositório.
 *
 * <p>Fornece operações de persistência, busca e exclusão, mantendo
 * uma estrutura organizada e alinhada às boas práticas de arquitetura
 * em camadas.</p>
 *
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    /**
     * Retorna todos os pagamentos cadastrados.
     *
     * @return lista de pagamentos
     */
    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    /**
     * Busca um pagamento pelo seu identificador.
     *
     * @param id identificador do pagamento
     * @return um {@link Optional} contendo o pagamento, caso exista
     */
    public Optional<Pagamento> buscarPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    /**
     * Persiste ou atualiza um pagamento no banco de dados.
     *
     * @param pagamento objeto a ser salvo
     * @return pagamento salvo
     */
    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    /**
     * Remove um pagamento com base no seu identificador.
     *
     * @param id identificador do pagamento a ser excluído
     */
    public void deletar(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
