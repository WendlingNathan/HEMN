package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Endereco;
import br.com.hemn.backend.repository.EnderecoRepository;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public Endereco atualizar(Long id, Endereco enderecoAtualizado) {
        Endereco endereco = buscarPorId(id);

        endereco.setLogradouro_end(enderecoAtualizado.getLogradouro_end());
        endereco.setNumero_end(enderecoAtualizado.getNumero_end());
        endereco.setBairro_end(enderecoAtualizado.getBairro_end());
        endereco.setCidade_end(enderecoAtualizado.getCidade_end());
        endereco.setCoplemento_end(enderecoAtualizado.getCoplemento_end());
        endereco.setPont_ref_end(enderecoAtualizado.getPont_ref_end());

        return enderecoRepository.save(endereco);
    }

    public void deletar(Long id) {
        Endereco endereco = buscarPorId(id);
        enderecoRepository.delete(endereco);
    }
}
