package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Cliente;
import br.com.hemn.backend.repository.ClienteRepository;

/**
 * Serviço responsável pela lógica de negócio relacionada à entidade {@link Cliente}.
 *
 * <p>Centraliza operações de CRUD e consultas específicas,
 * garantindo separação de responsabilidades entre camada de controle e persistência.</p>
 * 
 * @author Nathan Ritter Wendling
 * @author Eduardo Augusto Romio Nofre
 * @author Marco Antônio Schons Santos
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Retorna todos os clientes cadastrados.
     *
     * @return lista de clientes
     */
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Busca um cliente pelo ID.
     *
     * @param id identificador do cliente
     * @return cliente encontrado
     * @throws RuntimeException caso o cliente não exista
     */
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado: ID " + id));
    }

    /**
     * Salva ou atualiza um cliente.
     *
     * @param cliente objeto a ser salvo
     * @return cliente persistido
     */
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Exclui um cliente pelo ID.
     *
     * @param id identificador do cliente
     */
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
