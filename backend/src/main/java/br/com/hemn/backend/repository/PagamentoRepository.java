package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemn.backend.model.Pagamento;

public interface PagamentoRepository extends JpaRepository <Pagamento,Long>{
	List<Pagamento> findById(int id_pag);
}
