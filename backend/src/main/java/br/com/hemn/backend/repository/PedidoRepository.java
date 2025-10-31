package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hemn.backend.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	List<Pedido> findByStatusPed(String status_ped);
}
