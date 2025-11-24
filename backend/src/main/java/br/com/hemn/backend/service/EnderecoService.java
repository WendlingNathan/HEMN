package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Endereco;
import br.com.hemn.backend.repository.EnderecoRepository;

/**
 * Serviço responsável pela lógica de negócio referente à entidade {@link Endereco}.
 *
 * <p>Oferece operações de CRUD e consultas específicas,
 * mantendo a organização da arquitetura em camadas.</p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    /**
     * Lista todos os endereços cadastrados.
     *
     * @return lista de endereços
     */
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    /**
     * Busca um endereço pelo ID.
     *
     * @param id identificador do endereço
     * @return endereço encontrado
     * @throws RuntimeException caso o endereço não exista
     */
    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado: ID " + id));
    }

    /**
     * Salva ou atualiza um endereço.
     *
     * @param endereco objeto a ser salvo
     * @return endereço persistido
     */
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    /**
     * Exclui um endereço pelo ID.
     *
     * @param id identificador do endereço
     */
    public void deletar(Long id) {
        enderecoRepository.deleteById(id);
    }
}
