package br.com.hemn.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemn.backend.model.ComposicaoProduto;

public interface ComposicaoProdutoRepository extends JpaRepository<ComposicaoProduto,Long>{
	List<ComposicaoProduto> findByIngrediente_IdIng(Long id_ing);
}
