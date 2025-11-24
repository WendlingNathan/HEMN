package br.com.hemn.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hemn.backend.model.Pedido;
import br.com.hemn.backend.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado: ID " + id));
    }

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> buscarPorStatus(String status) {
        return pedidoRepository.findByStatusPed(status);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
