package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Cliente;
import br.com.hemn.backend.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(id);

        cliente.setNome_cli(clienteAtualizado.getNome_cli());
        cliente.setEmail_cli(clienteAtualizado.getEmail_cli());
        cliente.setCpf_cli(clienteAtualizado.getCpf_cli());
        cliente.setId_end(clienteAtualizado.getId_end());

        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }
}
