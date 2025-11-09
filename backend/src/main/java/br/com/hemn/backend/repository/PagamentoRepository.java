package br.com.hemn.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemn.backend.model.Pagamento;

public interface PagamentoRepository extends JpaRepository <Pagamento,Long>{
}
