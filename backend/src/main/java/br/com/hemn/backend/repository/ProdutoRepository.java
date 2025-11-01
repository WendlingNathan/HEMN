package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemn.backend.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto>FindByNomeProdContainingIgnoreCase(String nome_prod);
}
